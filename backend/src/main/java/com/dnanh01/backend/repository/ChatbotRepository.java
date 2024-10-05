package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.Chatbot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatbotRepository extends JpaRepository<Chatbot, UUID> {
}
