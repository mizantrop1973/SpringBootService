package com.java.service.repositories;

import com.java.service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstName(String firstName);
    List<User> findAllByLastName(String lastName);
    List<User> findAllByFirstNameAndLastName(String firstName, String lastName);
    List<User> findAllByIdAndFirstNameAndLastName(Long id, String firstName, String lastName);
    List<User> findAllByIdAndFirstName(Long id, String firstName);
    List<User> findAllByIdAndLastName(Long id, String lastName);




}
