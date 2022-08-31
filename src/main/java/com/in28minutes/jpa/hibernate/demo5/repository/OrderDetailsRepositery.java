package com.in28minutes.jpa.hibernate.demo5.repository;

import com.in28minutes.jpa.hibernate.demo5.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepositery extends JpaRepository<OrderDetails,Integer> {

}
