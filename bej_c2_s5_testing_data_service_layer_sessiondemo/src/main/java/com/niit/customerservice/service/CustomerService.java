package com.niit.customerservice.service;

import com.niit.customerservice.domain.Customer;
import com.niit.customerservice.exception.CustomerAlreadyExistsException;
import com.niit.customerservice.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    Customer saveCustomerDetail(Customer customer) throws CustomerAlreadyExistsException;
    boolean deleteCustomer(int id) throws CustomerNotFoundException;


    List<Customer> getAllCustomerDetail() throws Exception;
}
