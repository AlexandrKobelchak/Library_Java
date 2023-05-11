package com.example.domain.dao;

import com.example.domain.models.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ILibrarianRepository extends CrudRepository<Librarian, Long> {

}
