package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PromotionRepository extends JpaRepository<Promotion, UUID>{
}
