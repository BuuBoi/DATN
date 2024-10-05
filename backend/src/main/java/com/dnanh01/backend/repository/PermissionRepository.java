package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {
}
