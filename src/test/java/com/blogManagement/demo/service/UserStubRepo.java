package com.blogManagement.demo.service;

import com.blogManagement.demo.repository.*;
import com.blogManagement.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStubRepo extends UserRepo {
    User findByEmail(String email);
}
