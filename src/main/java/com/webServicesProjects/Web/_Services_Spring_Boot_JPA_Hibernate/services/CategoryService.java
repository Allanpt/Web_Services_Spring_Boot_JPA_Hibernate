package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.services;

import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.Category;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository CategoryRepository;

    public List<Category> findAll(){
        return CategoryRepository.findAll();
    }
    public Category findById(Long id){
        Optional<Category> obj = CategoryRepository.findById(id);
        return obj.get();
    }
}
