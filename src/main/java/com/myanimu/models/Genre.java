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
            name = "genre_serie",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "series")}
    )
    private Set<Serie> series;

    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "genre_film",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "films")}
    )
    private Set<Film> films;

    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "genre_manga",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "manga")}
    )
    private Set<Manga> mangas;

    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "genre_novel",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "novel")}
    )
    private Set<Novel> novels;
}
