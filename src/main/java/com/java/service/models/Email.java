package com.java.service.models;

import com.java.service.forms.ContactsForm;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "emailOwner")
@Entity
@Table(name = "email")

public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    @Column(name = "phone_number")
    private String email;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Client emailOwner;

    public  static Email fromContactsEmail(ContactsForm contactsForm, Client client) {
        return Email.builder()
                .email(contactsForm.getEmail())
                .emailOwner(client)
                .build();
    }
}

