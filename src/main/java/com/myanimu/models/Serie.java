package com.myanimu.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}
