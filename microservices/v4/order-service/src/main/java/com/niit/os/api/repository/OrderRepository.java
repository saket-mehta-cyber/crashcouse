package com.niit.os.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niit.os.api.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
