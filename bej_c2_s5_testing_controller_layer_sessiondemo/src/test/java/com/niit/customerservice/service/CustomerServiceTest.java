package com.niit.customerservice.service;


import static org.junit.jupiter.api.Assertions.*;

import com.niit.customerservice.domain.Address;
import com.niit.customerservice.domain.Customer;
import com.niit.customerservice.exception.CustomerAlreadyExistsException;
import com.niit.customerservice.exception.CustomerNotFoundException;
import com.niit.customerservice.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {


    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;
    private Customer customer1, customer2;
    List<Customer> customerList;
    Address address1,address2;



    @BeforeEach
    public void setUp(){

     address1 = new Address("city1","state1","pincode1");
     customer1 = new Customer(1001,"Johny",address1,1234);
     address2 = new Address("city2","state2","pincode2");
     customer2 = new Customer(1002,"Harry",address2,87654);
     customerList = Arrays.asList(customer1,customer2);
    }

    @AfterEach
    public void tearDown()
    {
        customer1=null;
        customer2 = null;

    }

    @Test
    public void givenCustomerToSaveReturnSavedCustomerSuccess() throws CustomerAlreadyExistsException {
      when(customerRepository.findById(customer1.getCustomerId())).thenReturn(Optional.ofNullable(null));
      when(customerRepository.save(any())).thenReturn(customer1);
      assertEquals(customer1,customerService.saveCustomerDetail(customer1));
      verify(customerRepository,times(1)).save(any());
      verify(customerRepository,times(1)).findById(any());

    }

    @Test
    public void givenCustomerToSaveReturnCustomerFailure(){
        when(customerRepository.findById(customer1.getCustomerId())).thenReturn(Optional.ofNullable(customer1));
        assertThrows(CustomerAlreadyExistsException.class,()->customerService.saveCustomerDetail(customer1));
        verify(customerRepository,times(0)).save(any());
        verify(customerRepository,times(1)).findById(any());
    }

    @Test
    public void givenCustomerToDeleteShouldDeleteSuccess() throws CustomerNotFoundException {
        when(customerRepository.findById(customer1.getCustomerId())).thenReturn(Optional.ofNullable(customer1));
        boolean flag = customerService.deleteCustomer(customer1.getCustomerId());
        assertEquals(true,flag);

        verify(customerRepository,times(1)).deleteById(any());
        verify(customerRepository,times(1)).findById(any());
    }

}
