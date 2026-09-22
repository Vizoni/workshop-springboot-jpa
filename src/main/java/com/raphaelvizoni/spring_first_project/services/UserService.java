package com.raphaelvizoni.spring_first_project.services;

import com.raphaelvizoni.spring_first_project.entities.User;
import com.raphaelvizoni.spring_first_project.repositories.UserRepository;
import com.raphaelvizoni.spring_first_project.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
//        try {
//            repository.deleteById(id);
//        } catch (EmptyResultDataAccessException e) {
//            throw new ResourceNotFoundException(id);
//        } catch (DataIntegrityViolationException e) {
//           throw new DataIntegrityViolationException(e.getMessage());
//        }

        // O código acima é o do curso, porém devido a versão diferente, não funciona
        // Com a solução abaixo eu consegui resolver o 404 caso tente deletar um usuário não existente
        // Porém ainda estou sem conseguir tratar o erro de banco, caso o usuário exista e esteja vinculado à algum pedido
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        repository.delete(user);
    }

    public User update(Long id, User obj) {
        try {
            User userToBeUpdated = repository.getReferenceById(id);
            updateData(userToBeUpdated, obj);
            return repository.save(userToBeUpdated);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User userToBeUpdated, User obj) {
        userToBeUpdated.setName(obj.getName());
        userToBeUpdated.setEmail(obj.getEmail());
        userToBeUpdated.setPhone(obj.getPhone());
        // Não pode atualizar ID nem senha através desse método
    }
}
