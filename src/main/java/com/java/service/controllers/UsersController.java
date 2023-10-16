package com.java.service.controllers;

import com.java.service.forms.UserForm;
import com.java.service.models.User;
import com.java.service.repositories.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
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
                                        usersRepository.findAllByUserIdAndLastName(userId, lastName) :
                                lastName == null ?
                                        usersRepository.findAllByUserIdAndFirstName(userId, firstName) :
                                        usersRepository.findAllByUserIdAndFirstNameAndLastName(userId, firstName, lastName) :
                        Collections.emptyList()
        ;
        for (User user : users) user.getCars().toString();
        model.addAttribute("usersFromServer", users);


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
