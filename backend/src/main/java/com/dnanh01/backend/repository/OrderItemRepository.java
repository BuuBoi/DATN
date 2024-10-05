package com.dnanh01.backend.repository;

import com.dnanh01.backend.model.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}
