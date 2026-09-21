package com.raphaelvizoni.spring_first_project.services;

import com.raphaelvizoni.spring_first_project.entities.Category;
import com.raphaelvizoni.spring_first_project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get(); // vai retornar o que tiver dentro do Optional
    }
}
