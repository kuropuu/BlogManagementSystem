package com.blogManagement.demo.service;

import com.blogManagement.demo.entity.Comment;
import com.blogManagement.demo.entity.Post;
import com.blogManagement.demo.entity.User;
import com.blogManagement.demo.repository.CategoryRepo;
import com.blogManagement.demo.repository.CommentRepo;
import com.blogManagement.demo.repository.PostRepo;
import com.blogManagement.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final PostRepo postRepo;
    private final CommentRepo commentRepo;
    private final UserRepo userRepo;
    private final CategoryRepo categoryRepo;

    @Autowired
    public BlogService(PostRepo postRepo, CommentRepo commentRepo, UserRepo userRepo, CategoryRepo categoryRepo) {
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
    }

    public List<Post> getAllPost(){
        return postRepo.findAll();
    }

    public Post getPostById(Long id){
        try{
            Post post = postRepo.findById(id).orElseThrow(()->new Exception("Post not found."));
            return post;
        }catch (Exception e){
            return null;
        }
    }

    public List<Post> getPostByCategory(String category) {
        List<Post> posts = getAllPost();
        List<Post> result = posts.stream().filter(post -> post.getCategory().getCategoryName().equalsIgnoreCase(category))
                .collect(Collectors.toList());
       return result;
    }

    public List<Post> getPostByDate(String date){
        LocalDate ld= LocalDate.parse(date);
        List<Post> posts = getAllPost();
        List<Post> result = posts.stream().filter(post -> post.getPublishDate().isEqual(ld)).collect(Collectors.toList());
        return result;
    }

    public List<Post> getPostByAuthorId(Long userId){
        List<Post> posts = getAllPost();
        List<Post> result = posts.stream().filter(post -> post.getAuthor().getId() == userId).collect(Collectors.toList());
        return result;
    }

    public List<Comment> getCommentsByPostId(Long postId){
        Post post = getPostById(postId);
        if (post != null){
            if (post.getComments() != null) return post.getComments();
            else return null;
        }else return null;
    }

    public List<Post> getUnapprovedPosts(){
        List<Post> posts = getAllPost();
        List<Post> result = posts.stream().filter(post -> !post.isApproved()).collect(Collectors.toList());
        return result;
    }


    public Post addPost(Post post){
        return postRepo.save(post);
    }

    public Post addCommentsToPost(Long postId,String comment){
        Post post = getPostById(postId);
        if (post != null) {
            Comment comment1 = new Comment();
            comment1.setContent(comment);
            comment1.setDateTime(LocalDateTime.now());
            List<Comment> comments = post.getComments();
            comments.add(commentRepo.save(comment1));
            post.setComments(comments);
            postRepo.save(post);
            postRepo.flush();
        }
        return post;
    }

    public Post updatePost(Post post){
       return postRepo.save(post);
    }

    public String deletePostById(Long id){
        Optional<Post> postTry = postRepo.findById(id);
        if (postTry.isPresent()){
            postRepo.deleteById(id);
            return postTry.get().getTitle()+" successfully deleted.";
        }else return "given post id doesn't exist";
    }

    public String deleteComment(Long postId,Long commentId){
        Optional<Post> postTry = postRepo.findById(postId);
        if (postTry.isPresent()){
            List<Comment> comments = postTry.get().getComments().stream().filter(comment -> comment.getId() != commentId)
                    .collect(Collectors.toList());
            postTry.get().setComments(comments);
            postRepo.flush();
            commentRepo.deleteById(commentId);
            return "comment "+commentId+ " successfully deleted from post "+postTry.get().getTitle()+".";
        }else return "given post id doesn't exist";

    }
}
