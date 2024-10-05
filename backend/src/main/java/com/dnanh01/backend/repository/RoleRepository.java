package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID>{
}
