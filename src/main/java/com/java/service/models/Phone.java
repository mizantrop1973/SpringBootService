package com.java.service.models;


import com.java.service.forms.ContactsForm;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "owner")
@Entity
@Table(name = "phone")

public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phoneId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Client owner;

    public  static Phone fromContactsPhone(ContactsForm contactsForm, Client client) {
        return Phone.builder()
                .phoneNumber(contactsForm.getPhoneNumber())
                .owner(client)
                .build();
    }
}
