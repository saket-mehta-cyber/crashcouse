package com.niit.customerservice.repository;

import com.niit.customerservice.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {
}
