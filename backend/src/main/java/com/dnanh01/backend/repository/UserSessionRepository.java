package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserSessionRepository extends JpaRepository<UserSession, UUID>{
}
