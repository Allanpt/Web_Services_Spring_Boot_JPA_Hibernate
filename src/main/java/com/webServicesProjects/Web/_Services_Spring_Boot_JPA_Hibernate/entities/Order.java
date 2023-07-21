package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy 'T' HH:mm:ss 'Z'", timezone = "GMT")
    private Instant orderMoment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    public Order(){

    }

    public Order(Long id, Instant orderMoment, User customer) {
        this.id = id;
        this.orderMoment = orderMoment;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getOrderMoment() {
        return orderMoment;
    }

    public void setOrderMoment(Instant orderMoment) {
        this.orderMoment = orderMoment;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
