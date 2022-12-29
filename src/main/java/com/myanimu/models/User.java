package com.myanimu.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
public class User {

    @Getter
    @Setter
    @Id
    @Column(name = "username")
    private String username;

    @Getter
    @Setter
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    @Column(name = "email", unique = true)
    private String email;

    @Getter
    @Setter
    @Column(name = "age", length = 2)
    private int age;

    @Getter
    @Setter
    @Column(name = "country", length = 3)
    private String country;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ListAnime listAnime;
}