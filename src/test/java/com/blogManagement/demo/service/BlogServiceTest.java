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
        System.out.println("getAllPost");
        Post post = new Post();
        post.setTitle("new post");
        instance.addPost(post);
        
        List<Post> posts = instance.getAllPost();
        assertEquals(post.getTitle(), posts.get(0).getTitle());

    }

    @Test
    public void testDeletePostById() {
        System.out.println("DeletePostById");
        Post post = new Post();
        post.setTitle("new");
        Post temp = instance.addPost(post);
        
        instance.deletePostById(temp.getId());
        Post result = instance.getPostById(temp.getId());
        assertNull(result);
    }

    @Test
    public void testGetPostByCategory(){
        System.out.println("DeletePostById");
        Post post = new Post();
        post.setTitle("new");
        Category category = new Category();
        category.setCategoryName("cat1");
        post.setCategory(category);
        Post temp = instance.addPost(post);
        
        List<Post> posts = instance.getPostByCategory(category.getCategoryName());
        assertEquals(1, posts.size());
    }

}
