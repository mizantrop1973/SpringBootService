package com.java.service.models;

import com.java.service.forms.ClientForm;
import com.java.service.forms.ContactsForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  clientId;

    @Column(name = "client_name")
    private String clientName;

    @OneToMany(mappedBy = "owner")
    private List<Phone> phones;

    @OneToMany(mappedBy = "emailOwner")
    private List<Email> emails;

    public static Client from(ClientForm clientForm) {
        return Client.builder()
                .clientName(clientForm.getClientName())
                .build();
    }

    @Override
    public String toString() {
        return
                clientName + " " + " (client_id " + clientId + ")"
                        +", Phones:" + getPhones()  + ", E-mails:" + getEmails() + "; ";
    }

}
