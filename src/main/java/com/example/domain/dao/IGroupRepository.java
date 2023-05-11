package com.example.domain.dao;

import com.example.domain.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IGroupRepository extends CrudRepository<Group, Long> {

}
