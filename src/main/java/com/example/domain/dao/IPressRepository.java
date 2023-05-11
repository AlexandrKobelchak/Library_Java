package com.example.domain.dao;

import com.example.domain.models.Press;
import com.example.domain.models.SCard;
import com.example.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IPressRepository extends CrudRepository<Press, Long> {

}
