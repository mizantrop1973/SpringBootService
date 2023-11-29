package com.java.service.repositories;

import com.java.service.models.Email;
import com.java.service.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Long> {

    List<Email> findAllByEmailOwner_clientName(String clientNameOwner);

}
