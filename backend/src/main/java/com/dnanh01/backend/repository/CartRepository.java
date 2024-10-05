package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID>{
}
