package com.raphaelvizoni.spring_first_project.repositories;

import com.raphaelvizoni.spring_first_project.entities.OrderItem;
import com.raphaelvizoni.spring_first_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
