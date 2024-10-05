package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SizeRepository extends JpaRepository<Size, UUID>{
}