package com.blogManagement.demo.service;

import com.blogManagement.demo.entity.Comment;
import com.blogManagement.demo.entity.Post;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        List<Post> posts = instance.getAllPost();
        int result =0;
        assertEquals(result, posts.size());

    }

}
