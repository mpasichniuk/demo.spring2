package com.example.demo.spring2.observers;

import com.example.demo.spring2.subjects.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRep extends JpaRepository<Order, Long> {

}


