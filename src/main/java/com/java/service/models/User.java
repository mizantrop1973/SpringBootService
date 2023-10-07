package com.java.mvc.models;


import com.java.mvc.forms.UserForm;
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
@Table(name = "fix_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static User from(UserForm userForm) {
        return User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .build();
    }
   @Override
    public String toString() {
        return
                firstName + " " + lastName + " (id " + id + ")"
                +", Cars:" + getCars() + "; ";
    }
}