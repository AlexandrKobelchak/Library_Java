package com.example.domain.dao.identity;

import com.example.domain.models.Identity.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<Role, Long> {

}
