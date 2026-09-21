package com.raphaelvizoni.spring_first_project.services;

import com.raphaelvizoni.spring_first_project.entities.Product;
import com.raphaelvizoni.spring_first_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get(); // vai retornar o que tiver dentro do Optional
    }
}
