package com.raphaelvizoni.spring_first_project.repositories;

import com.raphaelvizoni.spring_first_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
