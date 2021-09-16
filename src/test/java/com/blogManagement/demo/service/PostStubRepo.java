package com.blogManagement.demo.service;

import com.blogManagement.demo.repository.*;
import com.blogManagement.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostStubRepo extends PostRepo {
}
