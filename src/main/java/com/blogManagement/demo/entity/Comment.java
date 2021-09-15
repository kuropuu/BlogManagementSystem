package com.blogManagement.demo.entity;



import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue()
    @Column(nullable = false, updatable = false)
    private Long id;
    private LocalDateTime dateTime;
    private String content;
}
