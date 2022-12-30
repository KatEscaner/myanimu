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
@Table(name = "novel")
@ToString @EqualsAndHashCode
public class Novel extends Book{

    @Getter @Setter
    @Column(name = "numPages", length = 4)
    private int numPages;

    @Getter @Setter
    @ManyToMany(mappedBy = "novels")
    @JsonIgnoreProperties("novels")
    private Set<ListAnime> listAnimes;

    @Getter @Setter
    @ManyToMany(mappedBy = "novels")
    @JsonIgnoreProperties("novels")
    private Set<Genre> genres;
}