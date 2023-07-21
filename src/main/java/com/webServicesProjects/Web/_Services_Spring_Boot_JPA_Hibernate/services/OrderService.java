package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.services;

import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.Order;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.User;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
