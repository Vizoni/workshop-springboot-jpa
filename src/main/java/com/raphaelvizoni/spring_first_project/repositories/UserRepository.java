package com.raphaelvizoni.spring_first_project.repositories;

import com.raphaelvizoni.spring_first_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // não precisa implementar essa interface pois o JPA já tem uma implementação padrão para a definição passada (user,long)
}
