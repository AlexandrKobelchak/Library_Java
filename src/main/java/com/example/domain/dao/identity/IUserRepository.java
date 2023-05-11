package com.example.domain.dao.identity;

import com.example.domain.models.Identity.Role;
import com.example.domain.models.Identity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :name")
    User findByName(String name);
}

