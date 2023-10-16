package com.java.service.repositories;

import com.java.service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstName(String firstName);
    List<User> findAllByLastName(String lastName);
    List<User> findAllByFirstNameAndLastName(String firstName, String lastName);
    List<User> findAllByUserIdAndFirstNameAndLastName(Long userId, String firstName, String lastName);
    List<User> findAllByUserIdAndFirstName(Long userId, String firstName);
    List<User> findAllByUserIdAndLastName(Long userId, String lastName);

    Optional<User> findOneByLogin(String login);




}
