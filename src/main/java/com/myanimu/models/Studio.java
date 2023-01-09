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
    @Column(name = "name", length = 50, unique = true)
    private String name;

    @Getter @Setter
    @OneToMany(mappedBy = "studio", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Multimedia> multimedias;
}
