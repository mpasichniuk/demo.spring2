package com.example.demo.spring2;

import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRep extends JpaRepository<Order, Long> {

}


