package com.myanimu.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "studio")
@ToString @EqualsAndHashCode
public class Studio {

    @Getter @Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter
    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Multimedia> multimedias;
}
