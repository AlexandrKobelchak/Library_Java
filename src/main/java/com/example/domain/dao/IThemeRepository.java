package com.example.domain.dao;

import com.example.domain.models.Category;
import com.example.domain.models.Student;
import com.example.domain.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IThemeRepository extends CrudRepository<Theme, Long> {

}
