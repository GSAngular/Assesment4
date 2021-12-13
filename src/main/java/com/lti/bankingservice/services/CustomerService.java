package com.lti.bankingservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.bankingservice.exception.ResourceNotFoundException;
import com.lti.bankingservice.model.Customer;

@Service
public interface CustomerService {

     public List<Customer> getAllCustomer();
	 
	 public Customer getCustomerByName(String name);
	 
	 public void deleteCustomerById(Long customerId) throws ResourceNotFoundException;
	 	 
	 public Customer saveOrUpdate(Customer customer);

}
