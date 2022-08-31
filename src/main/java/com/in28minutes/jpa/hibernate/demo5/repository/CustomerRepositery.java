package com.in28minutes.jpa.hibernate.demo5.repository;

import com.in28minutes.jpa.hibernate.demo5.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepositery extends JpaRepository<Customer,Integer> {}
