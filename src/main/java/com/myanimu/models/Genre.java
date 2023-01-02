package com.myanimu.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Getter @Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter
    @Column(name = "name", length = 20, unique = true)
    private String  name;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "genre_serie",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "series")}
    )
    @JsonIgnoreProperties("genres")
    private Set<Serie> series;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "genre_film",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "films")}
    )
    @JsonIgnoreProperties("genres")
    private Set<Film> films;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "genre_manga",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "manga")}
    )
    @JsonIgnoreProperties("genres")
    private Set<Manga> mangas;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "genre_novel",
            joinColumns = {@JoinColumn(name = "genre")},
            inverseJoinColumns = {@JoinColumn(name = "novel")}
    )
    @JsonIgnoreProperties("genres")
    private Set<Novel> novels;
}
