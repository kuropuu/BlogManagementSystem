package com.blogManagement.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @OneToOne
    private User author;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String message;
    private LocalDate publishDate;
    private LocalDate expiryDate;
    private boolean isApproved;

    @OneToOne
    private Category category;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}
