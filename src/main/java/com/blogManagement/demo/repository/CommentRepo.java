package com.blogManagement.demo.repository;

import com.blogManagement.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
