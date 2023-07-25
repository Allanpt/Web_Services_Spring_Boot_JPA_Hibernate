package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.services;

import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.Order;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.User;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
       return obj.get();
    }

    public User insert(User obj){
        return userRepository.save(obj);
    }
}
