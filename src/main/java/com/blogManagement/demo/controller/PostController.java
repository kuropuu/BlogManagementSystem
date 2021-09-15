package com.blogManagement.demo.controller;


import com.blogManagement.demo.entity.Comment;
import com.blogManagement.demo.entity.Post;
import com.blogManagement.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    private final BlogService service;

    @Autowired
    public PostController(BlogService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts = service.getAllPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id){
        Post post = service.getPostById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Post>> getPostByCategory(@RequestParam(name = "categoryName") String categoryName){
        List<Post> posts = service.getPostByCategory(categoryName);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Post>> getPostByDate(@PathVariable("date") String date){
        List<Post> posts = service.getPostByDate(date);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Post>> getPostByAuthorId(@PathVariable("authorId") Long authorId){
        List<Post> posts = service.getPostByAuthorId(authorId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/comments/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable("postId") Long postId){
        List<Comment> comments = service.getCommentsByPostId(postId);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }

    @GetMapping("/unapprovedPosts")
    public ResponseEntity<List<Post>> getUnapprovedPosts(){
        List<Post> posts = service.getUnapprovedPosts();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        Post newPost = service.addPost(post);
        return new ResponseEntity<>(newPost,HttpStatus.CREATED);
    }

    @PostMapping("/comment/{postId}")
    public ResponseEntity<Post> addComment(@PathVariable("postId") Long postId, @RequestBody Map<String,String> map){
        Post newPost = service.addCommentsToPost(postId,map.get("comment"));
        return new ResponseEntity<>(newPost,HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        Post updatedPost = service.updatePost(post);
        return new ResponseEntity<>(updatedPost,HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable("postId") Long postId){
        String message = service.deletePostById(postId);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/comment/{postId}/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId){
        String message = service.deleteComment(postId,commentId);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
