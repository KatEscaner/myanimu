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
import net.minidev.json.annotate.JsonIgnore;

import java.util.Set;

@Entity
@Table(name = "serie")
@ToString @EqualsAndHashCode
public class Serie extends Multimedia{

    @Getter @Setter
    @Column(name = "averageDuration", length = 3)
    private int averageDuration;

    @Getter @Setter
    @Column(name = "numCaps", length = 2)
    private int numCaps;

    @Getter @Setter
    @Column(name = "finished")
    private boolean finished;

    @Getter @Setter
    @ManyToMany(mappedBy = "series")
    @JsonIgnoreProperties("series")
    private Set<ListAnime> listAnimes;

    @Getter @Setter
    @ManyToMany(mappedBy = "series")
    @JsonIgnoreProperties("series")
    private Set<Genre> genres;
}
