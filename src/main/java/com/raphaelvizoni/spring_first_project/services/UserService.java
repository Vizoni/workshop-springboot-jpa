package com.raphaelvizoni.spring_first_project.services;

import com.raphaelvizoni.spring_first_project.entities.User;
import com.raphaelvizoni.spring_first_project.repositories.UserRepository;
import com.raphaelvizoni.spring_first_project.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User userToBeUpdated = repository.getReferenceById(id);
        updateData(userToBeUpdated, obj);
        return repository.save(userToBeUpdated);
    }

    private void updateData(User userToBeUpdated, User obj) {
        userToBeUpdated.setName(obj.getName());
        userToBeUpdated.setEmail(obj.getEmail());
        userToBeUpdated.setPhone(obj.getPhone());
        // Não pode atualizar ID nem senha através desse método
    }
}
