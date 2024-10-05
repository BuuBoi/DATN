package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolePermissionRepository extends JpaRepository<RolePermission, UUID>{
}
