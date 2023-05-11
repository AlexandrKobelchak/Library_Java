package com.example.domain.dao;

import com.example.domain.models.Department;
import com.example.domain.models.Student;
import com.example.domain.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IDepartmentRepository extends CrudRepository<Department, Long> {

}


