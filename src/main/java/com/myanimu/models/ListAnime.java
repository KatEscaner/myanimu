package com.myanimu.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

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
            CascadeType.PERSIST
        })
    @JoinTable(
            name = "list_serie",
            joinColumns = {@JoinColumn(name = "listAnime")},
            inverseJoinColumns = {@JoinColumn(name = "series")}
    )
    @JsonIgnoreProperties("listAnimes")
    private Set<Serie> series;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "list_film",
            joinColumns = {@JoinColumn(name = "listAnime")},
            inverseJoinColumns = {@JoinColumn(name = "films")}
    )
    @JsonIgnoreProperties("listAnimes")
    private Set<Film> films;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "list_manga",
            joinColumns = {@JoinColumn(name = "listAnime")},
            inverseJoinColumns = {@JoinColumn(name = "mangas")}
    )
    @JsonIgnoreProperties("listAnimes")
    private Set<Manga> mangas;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "list_novel",
            joinColumns = {@JoinColumn(name = "listAnime")},
            inverseJoinColumns = {@JoinColumn(name = "novel")}
    )
    @JsonIgnoreProperties("listAnimes")
    private Set<Novel> novels;
}
