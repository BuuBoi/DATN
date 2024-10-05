package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
}
