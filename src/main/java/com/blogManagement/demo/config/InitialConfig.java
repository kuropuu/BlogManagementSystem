package com.blogManagement.demo.config;

import com.blogManagement.demo.entity.Category;
import com.blogManagement.demo.entity.Role;
import com.blogManagement.demo.repository.CategoryRepo;
import com.blogManagement.demo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialConfig implements ApplicationRunner {


    private final CategoryRepo categoryRepo;
    private final RoleRepo roleRepo;

    @Autowired
    public InitialConfig(CategoryRepo categoryRepo, RoleRepo roleRepo) {
        this.categoryRepo = categoryRepo;
        this.roleRepo = roleRepo;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role role1= new Role();
        role1.setId(1L);
        role1.setRoleName("ADMIN");
        roleRepo.save(role1);

        Role role2= new Role();
        role2.setId(2L);
        role2.setRoleName("MANAGER");
        roleRepo.save(role2);

        Role role3= new Role();
        role3.setId(3L);
        role3.setRoleName("USER");
        roleRepo.save(role3);
        System.out.println("Creating roles...");

        Category c1 = new Category();
        c1.setId(1L);
        c1.setCategoryName("Technology");
        categoryRepo.save(c1);

        Category c2 = new Category();
        c2.setId(2L);
        c2.setCategoryName("Food");
        categoryRepo.save(c2);

        Category c3 = new Category();
        c3.setId(3L);
        c3.setCategoryName("Politics");
        categoryRepo.save(c3);
        System.out.println("Creating categories...");


    }
}
