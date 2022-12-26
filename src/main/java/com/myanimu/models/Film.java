package com.myanimu.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "film")
@ToString @EqualsAndHashCode
public class Film extends Multimedia{

    @Getter @Setter
    @Column(name = "duration", length = 3)
    private int duration;
}
