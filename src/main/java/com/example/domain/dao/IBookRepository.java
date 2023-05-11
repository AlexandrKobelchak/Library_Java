package com.example.domain.dao;

import com.example.domain.models.Author;
import com.example.domain.models.Book;
import com.example.domain.models.Student;
import com.example.domain.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends CrudRepository<Book, Long> {

}

