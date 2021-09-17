package com.blogManagement.demo.service;

import com.blogManagement.demo.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.blogManagement.demo.repository.CommentRepo;
import com.blogManagement.demo.repository.PostRepo;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogServiceTest {

    private final BlogService instance;
    private final PostRepo postRepo;
    private final CommentRepo commentRepo;

    private Post post1= new Post();


    @Autowired
    public BlogServiceTest(BlogService instance, PostRepo postRepo, CommentRepo commentRepo){
        this.instance = instance;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        post1.setTitle("test1");
        post1.setId(1L);
        Category c1 = new Category();
        c1.setId(1L);
        //category technology
        post1.setCategory(c1);
        User u1 = new User();
        u1.setId(1L);
        post1.setAuthor(u1);
        post1.setMessage("testing..");
        post1.setComments(null);
        postRepo.save(post1);
        commentRepo.deleteAll();
    }

//    @After
//    public void after(){
//        Post post = instance.getPostById(1L);
//        post.setComments(null);
//        postRepo.flush();
//        postRepo.deleteById(1L);
//    }


    @Test
    public void testGetAllPost() {
        // Create new post with test Category and add it to the database
//        System.out.println("getAllPost");
//        Post post = new Post();
//        post.setTitle("new post");
//        instance.addPost(post);
        // Check that post was added successfully
        List<Post> posts = instance.getAllPost();
//        assertEquals(post.getTitle(), posts.get(0).getTitle());
        // Delete testPost from database
        assertTrue(posts.size()>0);
//        instance.deletePostById(post.getId());
    }

    @Test
    public void testGetPostById() {
//        System.out.println("getPostById");
//        // Add two posts to the database
//        Post testPost1 = new Post();
//        testPost1.setTitle("testPost1");
//        instance.addPost(testPost1);
//        Post testPost2 = new Post();
//        testPost2.setTitle("testPost2");
//        instance.addPost(testPost2);
        // Check that we are able to specifically get testPost1, and then testPost2
//
//        Post query1 = instance.getPostById(testPost1.getId());
//        assertEquals(testPost1.getTitle(), query1.getTitle());
//        Post query2 = instance.getPostById(testPost2.getId());
//        assertEquals(testPost2.getTitle(), query2.getTitle());
        // Remove test posts from the database
//        instance.deletePostById(testPost1.getId());
//        instance.deletePostById(testPost2.getId());
        Post query1 = instance.getPostById(1L);
        assertEquals("test1", query1.getTitle());
    }



    @Test
    public void testGetPostByCategory(){
//        System.out.println("testGetPostByCategory");
//        // Create new post with test Category and add it to the database
//        Post testPost = new Post();
//        testPost.setTitle("new");
//        Category category = new Category();
//        category.setId(1L);
//        testPost.setCategory(category);
//        Post temp = instance.addPost(testPost);
        // Query for test Category
        List<Post> posts = instance.getPostByCategory("technology");
        assertEquals(1, posts.size());
        // Delete testPost from database
//        instance.deletePostById(temp.getId());
    }

    @Test
    public void testGetCommentsByPostId() {
        System.out.println("testGetCommentsByPostId");
        List<Comment> comments = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setContent("good content1.");
        comment1.setDateTime(LocalDateTime.now());
        Comment comment2 = new Comment();
        comment2.setContent("good content2.");
        comment2.setDateTime(LocalDateTime.now());
        comments.add(comment1);
        comments.add(comment2);
        post1.setComments(comments);
        postRepo.save(post1);
        List<Comment> queryComments = instance.getCommentsByPostId(1L);
        assertEquals("good content1.", queryComments.get(0).getContent());
        assertEquals("good content2.", queryComments.get(1).getContent());

//        // Delete testPost from database
//        long commentID = queryComments.get(0).getId();
//        instance.deleteComment(testPost1.getId(),commentID);
//        instance.deletePostById(testPost1.getId());
    }


    @Test
    public void testUpdatePost(){
        Post post = instance.getPostById(1L);
        post.setTitle("updated title");
        postRepo.save(post);
        Post updatedPost = instance.getPostById(1L);
        assertEquals("updated title",updatedPost.getTitle());
    }

    @Test
    public void testDeletePostById() {
        System.out.println("DeletePostById");
        // Create new post with test Category and add it to the database
        Post post = new Post();
        post.setTitle("new");
        Post temp = instance.addPost(post);
//         Delete post from database
        instance.deletePostById(temp.getId());
        Post result = instance.getPostById(temp.getId());
        assertNull(result);
    }


}
