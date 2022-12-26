package com.myanimu.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "listAnime")
public class ListAnime {

    @Getter @Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter
    @JoinColumn(name = "user", referencedColumnName = "username", unique = true)
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinTable(
            name = "list_multimedia",
            joinColumns = {@JoinColumn(name = "listAnime")},
            inverseJoinColumns = {@JoinColumn(name = "multimedia")}
    )
    private Set<Multimedia> multimedias;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "list_book",
            joinColumns = {@JoinColumn(name = "listAnime")},
            inverseJoinColumns = {@JoinColumn(name = "book")}
    )
    private Set<Book> books;
}
