package com.java.mvc.repositories;

import com.java.mvc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstName(String firstName);
}
