package com.blogManagement.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {

    @Id
    private Long id;
    private String roleName;

}
