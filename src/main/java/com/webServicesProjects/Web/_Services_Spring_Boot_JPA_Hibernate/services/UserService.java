package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.services;

import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.User;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories.UserRepository;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.services.exceptions.DatabaseException;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.services.exceptions.EntityException;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
       Optional<User> obj = userRepository.findById(id);
       return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return userRepository.save(obj);
    }

    public void delete(Long id){
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try {
            User entity = userRepository.getReferenceById(id);
            updateData(entity, obj);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e){
            throw new EntityException(e.getMessage());
        }

    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
