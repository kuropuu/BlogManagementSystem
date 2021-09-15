package com.blogManagement.demo.service;


import com.blogManagement.demo.entity.User;
import com.blogManagement.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User login(String email, String password){
        User user = userRepo.findByEmail(email);
        if (user != null){
            if (user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
