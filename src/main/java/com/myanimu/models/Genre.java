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
    @Column(name = "name", length = 20, unique = true)
    private String  name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "genre_multimedia",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "multimedia")}
    )
    private Set<Multimedia> multimedias;

    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "genre_book",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "book")}
    )
    private Set<Book> books;
}
