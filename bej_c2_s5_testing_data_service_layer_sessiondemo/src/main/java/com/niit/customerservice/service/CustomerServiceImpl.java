package com.niit.customerservice.service;

import com.niit.customerservice.domain.Customer;
import com.niit.customerservice.exception.CustomerAlreadyExistsException;
import com.niit.customerservice.exception.CustomerNotFoundException;
import com.niit.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomerDetail(Customer customer) throws CustomerAlreadyExistsException {
        if(customerRepository.findById(customer.getCustomerId()).isPresent())
        {
            throw new CustomerAlreadyExistsException();
        }
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(int customerCode) throws CustomerNotFoundException {
        boolean flag = false;
        if(customerRepository.findById(customerCode).isEmpty())
        {
            throw new CustomerNotFoundException();
        }
        else {
            customerRepository.deleteById(customerCode);
            flag = true;
        }
        return flag;

    }

    @Override
    public List<Customer> getAllCustomerDetail() throws Exception {
        return customerRepository.findAll();
    }
}
