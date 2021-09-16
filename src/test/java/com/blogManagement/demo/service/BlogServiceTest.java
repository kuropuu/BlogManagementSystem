/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogManagement.demo.service;

import com.blogManagement.demo.entity.Comment;
import com.blogManagement.demo.entity.Post;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nasim
 */
public class BlogServiceTest {
    
    BlogService instance;
    
    public BlogServiceTest() {
        PostStubRepo postRepo;
        CommentStubRepo commentRepo;
        UserStubRepo userRepo;
        CategoryStubRepo categoryRepo;
        instance = new BlogService(postRepo, commentRepo, userRepo, categoryRepo);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllPost method, of class BlogService.
     */
    @Test
    public void testGetAllPost() {
        System.out.println("getAllPost");
        BlogService instance = null;
        List<Post> expResult = null;
        List<Post> result = instance.getAllPost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostById method, of class BlogService.
     */
    @Test
    public void testGetPostById() {
        System.out.println("getPostById");
        Long id = null;
        BlogService instance = null;
        Post expResult = null;
        Post result = instance.getPostById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostByCategory method, of class BlogService.
     */
    @Test
    public void testGetPostByCategory() {
        System.out.println("getPostByCategory");
        String category = "";
        BlogService instance = null;
        List<Post> expResult = null;
        List<Post> result = instance.getPostByCategory(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostByDate method, of class BlogService.
     */
    @Test
    public void testGetPostByDate() {
        System.out.println("getPostByDate");
        String date = "";
        BlogService instance = null;
        List<Post> expResult = null;
        List<Post> result = instance.getPostByDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostByAuthorId method, of class BlogService.
     */
    @Test
    public void testGetPostByAuthorId() {
        System.out.println("getPostByAuthorId");
        Long userId = null;
        BlogService instance = null;
        List<Post> expResult = null;
        List<Post> result = instance.getPostByAuthorId(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCommentsByPostId method, of class BlogService.
     */
    @Test
    public void testGetCommentsByPostId() {
        System.out.println("getCommentsByPostId");
        Long postId = null;
        BlogService instance = null;
        List<Comment> expResult = null;
        List<Comment> result = instance.getCommentsByPostId(postId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnapprovedPosts method, of class BlogService.
     */
    @Test
    public void testGetUnapprovedPosts() {
        System.out.println("getUnapprovedPosts");
        BlogService instance = null;
        List<Post> expResult = null;
        List<Post> result = instance.getUnapprovedPosts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPost method, of class BlogService.
     */
    @Test
    public void testAddPost() {
        System.out.println("addPost");
        Post post = null;
        BlogService instance = null;
        Post expResult = null;
        Post result = instance.addPost(post);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCommentsToPost method, of class BlogService.
     */
    @Test
    public void testAddCommentsToPost() {
        System.out.println("addCommentsToPost");
        Long postId = null;
        String comment = "";
        BlogService instance = null;
        Post expResult = null;
        Post result = instance.addCommentsToPost(postId, comment);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePost method, of class BlogService.
     */
    @Test
    public void testUpdatePost() {
        System.out.println("updatePost");
        Post post = null;
        BlogService instance = null;
        Post expResult = null;
        Post result = instance.updatePost(post);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePostById method, of class BlogService.
     */
    @Test
    public void testDeletePostById() {
        System.out.println("deletePostById");
        Long id = null;
        BlogService instance = null;
        String expResult = "";
        String result = instance.deletePostById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteComment method, of class BlogService.
     */
    @Test
    public void testDeleteComment() {
        System.out.println("deleteComment");
        Long postId = null;
        Long commentId = null;
        BlogService instance = null;
        String expResult = "";
        String result = instance.deleteComment(postId, commentId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
