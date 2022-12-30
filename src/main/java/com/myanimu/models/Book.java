package com.myanimu.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "book")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString @EqualsAndHashCode
public class Book {

    @Getter @Setter
    @Id
    @Column(name = "isbn", length = 13)
    private int isbn;

    @Getter @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Getter @Setter
    @Column(name = "year", length = 4)
    private int year;

    @Getter @Setter
    @Column(name = "finished")
    private boolean finished;

    @Getter @Setter
    @Column(name = "author", length = 50)
    private String author;

    @Getter @Setter
    @JoinColumn(name = "franchise")
    @ManyToOne()
    private Franchise franchise;

    @ManyToMany(mappedBy = "books")
    private Set<ListAnime> listAnimes;

    @ManyToMany(mappedBy = "books")
    private Set<Genre> genres;
}
