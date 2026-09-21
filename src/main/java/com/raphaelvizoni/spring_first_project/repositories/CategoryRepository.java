package com.raphaelvizoni.spring_first_project.repositories;

import com.raphaelvizoni.spring_first_project.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // não precisa implementar essa interface pois o JPA já tem uma implementação padrão para a definição passada (category,long)
}
