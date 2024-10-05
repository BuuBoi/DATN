package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShoeRepository extends JpaRepository<Shoe, UUID>{
}
