package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.services;

import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.Product;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> findAll(){
        return ProductRepository.findAll();
    }
    public Product findById(Long id){
        Optional<Product> obj = ProductRepository.findById(id);
        return obj.get();
    }
}
