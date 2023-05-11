package com.example.domain.dao;

import com.example.domain.models.Category;
import com.example.domain.models.Press;
import com.example.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {

}
