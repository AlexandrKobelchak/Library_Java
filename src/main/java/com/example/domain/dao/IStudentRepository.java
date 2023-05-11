package com.example.domain.dao;

import com.example.domain.models.Book;
import com.example.domain.models.Department;
import com.example.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Long> {

}


