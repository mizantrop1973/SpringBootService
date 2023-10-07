package com.java.service.controllers;

import com.java.service.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;


@Controller
public class UsersController {

    @Value("${my.property}")
    private String myProperty;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private DataSource dataSource;

    @GetMapping("/users")
    public String getUsersPage(ModelMap model) {
        System.out.println(myProperty);
        model.addAttribute("usersFromServer", usersRepository.findAll());
        return "users";

    }
}
