package com.blogManagement.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private User author;
    private String title;
    private String message;
    private LocalDateTime publishDate;
    private LocalDateTime expiryDate;
    private boolean isApproved;

    @OneToOne
    private Category category;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comments;
}
