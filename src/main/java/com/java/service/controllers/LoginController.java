package com.java.service.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Authentication authentication, ModelMap model, HttpServletRequest request) {
        System.out.println("Enter");
        if (authentication != null)
            return "redirect:/";
        if(request.getParameterMap().containsKey("error"))
            model.addAttribute("error",true);
        return "login";
    }
}
