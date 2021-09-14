package com.blogManagement.demo.repository;

import com.blogManagement.demo.entity.Category;
import com.blogManagement.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
}
