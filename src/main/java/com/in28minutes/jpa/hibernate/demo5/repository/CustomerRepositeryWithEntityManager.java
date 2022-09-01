package com.in28minutes.jpa.hibernate.demo5.repository;

import com.in28minutes.jpa.hibernate.demo5.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CustomerRepositeryWithEntityManager {
    @Autowired
    EntityManager em;
    public Customer findById(int id){

        return em.find(Customer.class, id);
    }
}
