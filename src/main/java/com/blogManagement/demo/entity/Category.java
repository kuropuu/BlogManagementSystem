package com.blogManagement.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {

    @Id
    private Long id;
    private String categoryName;
}
