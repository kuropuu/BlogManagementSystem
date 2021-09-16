package com.blogManagement.demo.service;

import com.blogManagement.demo.repository.*;
import com.blogManagement.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentStubRepo extends JpaRepository<Comment,Long> {
}
