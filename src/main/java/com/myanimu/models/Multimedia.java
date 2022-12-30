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
    @Column(name = "name", unique = true)
    private String name;

    @Getter @Setter
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Getter @Setter
    @Column(name = "year", length = 4)
    private int year;

    @Getter @Setter
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "franchise")
    private Franchise franchise;

    @Getter @Setter
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "studio")
    private Studio studio;

    @Getter @Setter
    @ManyToMany(mappedBy = "multimedias")
    private Set<Genre> genres;
}
