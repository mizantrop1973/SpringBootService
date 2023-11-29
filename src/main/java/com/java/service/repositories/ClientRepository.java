package com.java.service.repositories;


import com.java.service.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByClientName(String clientName);
    List<Client> findAllByClientIdAndClientName(Long clientId, String clientName);

}
