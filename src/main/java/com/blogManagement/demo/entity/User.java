package com.blogManagement.demo.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String email;
    private String password;

    @OneToOne
    private Role role;

}
