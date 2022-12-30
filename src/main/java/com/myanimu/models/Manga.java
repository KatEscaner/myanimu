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
@Table(name = "manga")
@ToString @EqualsAndHashCode
public class Manga extends Book{

    @Getter @Setter
    @Column(name = "numVolumes", length = 4)
    private int numVolumes;

    @ManyToMany(mappedBy = "mangas")
    @JsonIgnoreProperties("mangas")
    private Set<ListAnime> listAnimes;
}
