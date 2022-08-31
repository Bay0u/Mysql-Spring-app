package com.in28minutes.jpa.hibernate.demo5.repository;

import com.in28minutes.jpa.hibernate.demo5.entity.Orders;
import com.in28minutes.jpa.hibernate.demo5.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepositery extends JpaRepository<Orders, Integer> {

}
