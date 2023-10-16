package com.java.service.security.details;


import com.java.service.models.User;
import com.java.service.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceDetailImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        /*Optional<User> userCandidate = usersRepository.findOneByLogin(login);
         if(userCandidate.isPresent())
             return new UserDetailsImpl(userCandidate.get());
         else throw new IllegalArgumentException("User not found");*/
        return new UserDetailsImpl(usersRepository
                .findOneByLogin(login)
                .orElseThrow(IllegalArgumentException::new)
        );
    }
}
