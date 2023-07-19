package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.resources;

import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Allan Tavares","allan@gmail.com","999324324","1232131");
        return ResponseEntity.ok().body(u);
    }
}
