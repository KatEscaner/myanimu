package com.myanimu.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "manga")
@ToString @EqualsAndHashCode
public class Manga extends Book{

    @Getter @Setter
    @Column(name = "numVolumes", length = 4)
    private int numVolumes;
}
