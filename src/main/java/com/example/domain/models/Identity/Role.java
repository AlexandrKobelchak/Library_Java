package com.example.domain.models.Identity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Getter
@Table(name = "t_role")
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "id")
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    @Column(name = "name", length = 128, nullable = false)
    String name;

    @ManyToMany(mappedBy = "roles")
    Set<User> users;

    @Override
    public String getAuthority() {

        return getName();
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
