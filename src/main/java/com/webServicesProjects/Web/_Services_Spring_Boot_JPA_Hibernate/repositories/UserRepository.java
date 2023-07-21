package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories;

import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

}
