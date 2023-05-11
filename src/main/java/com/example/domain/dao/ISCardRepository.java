package com.example.domain.dao;

import com.example.domain.models.SCard;
import com.example.domain.models.Student;
import com.example.domain.models.TCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ISCardRepository extends CrudRepository<SCard, Long> {

}

