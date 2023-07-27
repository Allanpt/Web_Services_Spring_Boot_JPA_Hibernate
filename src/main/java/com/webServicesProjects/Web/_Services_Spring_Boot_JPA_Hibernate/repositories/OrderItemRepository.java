package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories;

import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}