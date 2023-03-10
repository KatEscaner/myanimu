package com.myanimu.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "film")
@ToString @EqualsAndHashCode
public class Film extends Multimedia{

    @Getter @Setter
    @Column(name = "duration", length = 3)
    private int duration;

    @Getter @Setter
    @ManyToMany(mappedBy = "films")
    @JsonIgnoreProperties("films")
    private Set<ListAnime> listAnimes;

    @Getter @Setter
    @ManyToMany(mappedBy = "films")
    @JsonIgnoreProperties("films")
    private Set<Genre> genres;
}
