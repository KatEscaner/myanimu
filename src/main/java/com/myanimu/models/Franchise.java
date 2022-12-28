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
    @Column(name = "name", length = 50)
    private String name;

    @Getter @Setter
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Multimedia> multimedias;

    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;
}
