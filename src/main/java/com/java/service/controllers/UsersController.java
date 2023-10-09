package com.java.service.controllers;

import com.java.service.forms.UserForm;
import com.java.service.models.User;
import com.java.service.repositories.UsersRepository;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class UsersController {
    @Value("${my.property}")
    private String myProperty;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private DataSource dataSource;

    @GetMapping("/users")
    @Transactional
    public String getUsersPage(
            ModelMap model,
            @RequestParam(name = "user_id", required = false) Long userId,
            @RequestParam(value = "first_name", required = false ) String firstName,
            @RequestParam(value = "last_name", required = false ) String lastName) {
        System.out.println(myProperty);
        List<User> users = userId == null ?
                firstName == null ?
                        lastName == null ?
                                usersRepository.findAll() :
                                usersRepository.findAllByLastName(lastName) :
                        lastName == null ?
                                usersRepository.findAllByFirstName(firstName) :
                                usersRepository.findAllByFirstNameAndLastName(firstName,lastName) :
                usersRepository.findById(userId).isPresent() ?
                        firstName == null ?
                                lastName == null ?
                                        Collections.singletonList(usersRepository.findById(userId).get()) :
                                        usersRepository.findAllByIdAndLastName(userId, lastName) :
                                lastName == null ?
                                        usersRepository.findAllByIdAndFirstName(userId, firstName) :
                                        usersRepository.findAllByIdAndFirstNameAndLastName(userId, firstName, lastName) :
                        Collections.emptyList()
        ;
        model.addAttribute("usersFromServer", users);
        for (User user : users) user.getCars().toString();

        return "users";
    }
    @PostMapping("/users")
    public String addUser(UserForm userForm) {
        System.out.println("Registration");
        User newUser = User.from(userForm);
        usersRepository.save(newUser);
        return "redirect:/users";
    }

}
