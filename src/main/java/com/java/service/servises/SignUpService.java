package com.java.service.servises;

import com.java.service.forms.UserForm;
import org.springframework.stereotype.Service;


public interface SignUpService {
    void signUp(UserForm userForm);
}
