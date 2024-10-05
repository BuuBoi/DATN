package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
}
