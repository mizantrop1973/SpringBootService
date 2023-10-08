package com.java.service.controllers;

import com.java.service.models.User;
import com.java.service.repositories.UsersRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Controller
public class UsersController {

    @Value("${my.property}")
    private String myProperty;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private DataSource dataSource;

    //@GetMapping("/users{first_name}")
    /*public String getUsersPage(ModelMap model) {
        System.out.println(myProperty);
        model.addAttribute("usersFromServer", usersRepository.findAll());
        return "users";
    }*/
   /* public String getUsersPage(
            ModelMap model,
            @RequestParam(required = false, name = "user_id") Long userId,
            @PathVariable(value = "first_name", required = false ) String firstName) {
        System.out.println(myProperty);
        Optional<User> user = usersRepository.findById(userId);
        List<User> users = usersRepository.findAllByFirstName(firstName);
        model.addAttribute(
                "usersFromServer",
                firstName != null ?
                        users.isEmpty() ?
                                users :
                                user.isPresent() ?
                                        Collections.singletonList(user.get()) : Optional.empty() :
                        user.isPresent() ?
                                Collections.singletonList(user.get()) :  usersRepository.findAll()
                );
        return "users";
    }*/

    public String getUsersPage(
            ModelMap model,
            @PathVariable(value = "first_name", required = false ) String firstName) {
        System.out.println(myProperty);
        model.addAttribute(
                "usersFromServer",
                firstName.isEmpty() ? usersRepository.findAll() : usersRepository.findAllByFirstName(firstName)
        );
        return "users";
    }

    @GetMapping("/users{userId}")
    public String getUser(
            ModelMap model,
            @PathVariable(value = "userId", required = false ) Long userId) {
        System.out.println(myProperty);
        model.addAttribute(
                "usersFromServer",
                userId == null ?
                        usersRepository.findAll() :
                        usersRepository.findById(userId).isPresent() ?
                                Collections.singletonList(usersRepository.findById(userId).get()) :
                                Collections.emptyList());
        return "users";
    }
   // @PostMapping
}
