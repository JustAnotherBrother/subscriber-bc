package com.example.subscriber_bc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private boolean isActive;
}
