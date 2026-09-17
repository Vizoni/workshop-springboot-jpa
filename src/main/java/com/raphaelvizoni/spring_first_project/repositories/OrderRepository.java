package com.raphaelvizoni.spring_first_project.repositories;

import com.raphaelvizoni.spring_first_project.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
