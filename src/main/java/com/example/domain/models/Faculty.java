package com.example.domain.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "faculties", indexes = {
        @Index(name = "name_index", columnList = "name", unique = true)
})
public class Faculty implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length = 64, nullable = false)
    private String name;

    @OneToMany(mappedBy = "faculty")
    private Set<Group> groups;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Group> getGroups() {
        return groups;
    }
}


