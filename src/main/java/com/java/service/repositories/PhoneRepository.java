package com.java.service.repositories;


import com.java.service.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findAllByOwner_clientName(String clientNameOwner);

}
