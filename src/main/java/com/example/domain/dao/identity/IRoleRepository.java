package com.example.domain.dao.identity;

import com.example.domain.models.Identity.AppRole;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<AppRole, Long> {

}
