package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID>{
}
