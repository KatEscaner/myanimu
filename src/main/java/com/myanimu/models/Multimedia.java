package com.myanimu.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "multimedia")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString @EqualsAndHashCode
public class Multimedia {

    @Getter @Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Getter @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter
    @Column(name = "description")
    private String description;

    @Getter @Setter
    @Column(name = "year", length = 4)
    private int year;

    @Getter @Setter
    @Column(name = "finished")
    private boolean finished;

    @ManyToOne()
    @JoinColumn(name = "franchise")
    private Franchise franchise;

    @ManyToOne()
    @JoinColumn(name = "studio")
    private Studio studio;

    @ManyToMany(mappedBy = "multimedias")
    private Set<ListAnime> listAnimes;

    @ManyToMany(mappedBy = "multimedias")
    private Set<Genre> genres;
}
