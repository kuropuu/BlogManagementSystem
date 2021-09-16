/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogManagement.demo.service;

import com.blogManagement.demo.entity.Comment;
import com.blogManagement.demo.entity.Post;
import com.blogManagement.demo.repository.CategoryRepo;
import com.blogManagement.demo.repository.CommentRepo;
import com.blogManagement.demo.repository.PostRepo;
import com.blogManagement.demo.repository.UserRepo;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author nasim
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MocksApplication.class)
public class BlogServiceTest {
    
    @Autowired
    PostRepo postRepo;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    BlogService instance;
    

    /**
     * Test of getPostByDate method, of class BlogService.
     */
    @Test
    public void testGetPostByDate() {
        System.out.println("getPostByDate");
        String date = "";
        List<Post> expResult = null;
        List<Post> result = instance.getPostByDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
 
}
