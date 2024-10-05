package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.KnowledgeBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KnowledgeBaseRepository extends JpaRepository<KnowledgeBase, UUID>{
}
