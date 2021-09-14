package com.blogManagement.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class User {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    private String password;

    @OneToOne
    private Role role;

}
