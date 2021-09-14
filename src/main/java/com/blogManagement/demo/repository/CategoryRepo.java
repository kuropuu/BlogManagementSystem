package com.blogManagement.demo.repository;

import com.blogManagement.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
