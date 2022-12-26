package com.myanimu.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "genre")
@ToString @EqualsAndHashCode
public class Genre {

    @Getter @Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter
    @Column(name = "name", length = 20)
    private String  name;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "genre_multimedia",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "multimedia")}
    )
    private Set<Multimedia> multimedias;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "genre_book",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "book")}
    )
    private Set<Book> books;
}