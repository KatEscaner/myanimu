package com.myanimu.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "franchise")
@ToString @EqualsAndHashCode
public class Franchise {

    @Getter @Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter
    @Column(name = "name", length = 50, unique = true)
    private String name;

    @Getter @Setter
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Getter @Setter
    @OneToMany(mappedBy = "franchise", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Multimedia> multimedias;

    @Getter @Setter
    @OneToMany(mappedBy = "franchise", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Book> books;
}
