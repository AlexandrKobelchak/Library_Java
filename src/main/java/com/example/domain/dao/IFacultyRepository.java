package com.example.domain.dao;

import com.example.domain.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IFacultyRepository extends CrudRepository<Faculty, Long> {

}

