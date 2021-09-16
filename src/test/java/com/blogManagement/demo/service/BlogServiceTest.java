package com.blogManagement.demo.service;

import com.blogManagement.demo.entity.Category;
import com.blogManagement.demo.entity.Comment;
import com.blogManagement.demo.entity.Post;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogServiceTest {

    @Autowired
    private BlogService instance;

    @Test
    public void testGetAllPost() {
        // Create new post with test Category and add it to the database
        System.out.println("getAllPost");
        Post post = new Post();
        post.setTitle("new post");
        instance.addPost(post);
        // Check that post was added successfully
        List<Post> posts = instance.getAllPost();
        assertEquals(post.getTitle(), posts.get(0).getTitle());
        // Delete testPost from database
        instance.deletePostById(post.getId());
    }

    @Test
    public void testGetPostById() {
        System.out.println("getPostById");
        // Add two posts to the database
        Post testPost1 = new Post();
        testPost1.setTitle("testPost1");
        instance.addPost(testPost1);
        Post testPost2 = new Post();
        testPost2.setTitle("testPost2");
        instance.addPost(testPost2);
        // Check that we are able to specifically get testPost1, and then testPost2
        Post query1 = instance.getPostById(testPost1.getId());
        assertEquals(testPost1.getTitle(), query1.getTitle());
        Post query2 = instance.getPostById(testPost2.getId());
        assertEquals(testPost2.getTitle(), query2.getTitle());
        // Remove test posts from the database
        instance.deletePostById(testPost1.getId());
        instance.deletePostById(testPost2.getId());
    }



    @Test
    public void testGetPostByCategory(){
        System.out.println("testGetPostByCategory");
        // Create new post with test Category and add it to the database
        Post testPost = new Post();
        testPost.setTitle("new");
        Category category = new Category();
        category.setCategoryName("testCategory1");
        testPost.setCategory(category);
        Post temp = instance.addPost(testPost);
        // Query for test Category
        List<Post> posts = instance.getPostByCategory(category.getCategoryName());
        assertEquals(1, posts.size());
        // Delete testPost from database
        instance.deletePostById(temp.getId());
    }

    @Test
    public void testGetCommentsByPostId() {
        System.out.println("testGetCommentsByPostId");
        // Add test post to database
        Post testPost1 = new Post();
        testPost1.setTitle("testPost1");
        instance.addPost(testPost1);
        // Add comment to the post
        instance.addCommentsToPost(testPost1.getId(), "testComment1");
        List<Comment> queryComments = instance.getCommentsByPostId(testPost1.getId());
        assertEquals("testComment1", queryComments.get(0).getContent());
    }

    @Test
    public void testDeletePostById() {
        System.out.println("DeletePostById");
        // Create new post with test Category and add it to the database
        Post post = new Post();
        post.setTitle("new");
        Post temp = instance.addPost(post);
        // Delete post from database
        instance.deletePostById(temp.getId());
        Post result = instance.getPostById(temp.getId());
        assertNull(result);
    }
}
