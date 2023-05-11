package com.example.domain.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "libs", indexes = {
        @Index(name = "first_name_index", columnList = "first_name"),
        @Index(name = "last_name_index", columnList = "last_name"),
        @Index(name = "full_name_index", columnList = "first_name, last_name"),
})
public class Librarian implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "first_name", length = 64, nullable = false)
    private String FirstName;

    @Column(name = "last_name", length = 64, nullable = false)
    private String LastName;

    @OneToMany(mappedBy = "librarian")
    private Set<SCard> sCards;
    @OneToMany(mappedBy = "librarian")
    private Set<TCard> tCards;
}
