package com.myanimu.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "novel")
@ToString @EqualsAndHashCode
public class Novel extends Book{

    @Getter @Setter
    @Column(name = "numPag", length = 4)
    private int numPag;
}
