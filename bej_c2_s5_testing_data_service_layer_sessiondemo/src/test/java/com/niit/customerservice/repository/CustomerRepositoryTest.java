package com.niit.customerservice.repository;


import com.niit.customerservice.domain.Address;
import com.niit.customerservice.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {



    @Autowired
    private CustomerRepository customerRepository;
    private Address address;
    private Customer customer;


    @BeforeEach
    public void setUp(){

        address = new Address("city1","state1","pincode1");

      customer = new Customer(1001,"Jonny",address,12345);
    }

    @AfterEach
    public void tearDown(){

     address = null;
     customer = null;
        customerRepository.deleteAll();
    }

    @Test
    public void givenCustomerToSaveShouldReturnCustomer(){

        customerRepository.insert(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        assertNotNull(customer1);
        assertEquals(customer.getCustomerId(),customer1.getCustomerId());


    }


    @Test
    public void givenCustomerToDeleteShouldDeleteCustomer(){
        customerRepository.insert(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();

        customerRepository.delete(customer1);
       assertEquals(Optional.empty(),customerRepository.findById(customer.getCustomerId()));


    }

    @Test
    public void givenTrackReturnGetAllTrack(){

        customerRepository.insert(customer);
        Address address1 = new Address("city1","state2","pincode2");
        Customer customer1 = new Customer(1002,"Harry",address1,123456);
        customerRepository.insert(customer1);

        List<Customer> list = customerRepository.findAll();
        assertEquals(2,list.size());
        assertEquals("Harry",list.get(1).getCustomerName());

    }

}
