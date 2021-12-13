package com.lti.bankingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bankingservice.exception.ResourceNotFoundException;
import com.lti.bankingservice.model.Customer;
import com.lti.bankingservice.service.impl.CustomerServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/customer")
	private List<Customer> getAllCustomers(){
	  return customerServiceImpl.getAllCustomer();				
	}
	
	@PostMapping("/customer")
	private ResponseEntity<Integer> addCustomer(@RequestBody Customer customer) {
	 customerServiceImpl.saveOrUpdate(customer);
	 return new ResponseEntity(customer.getCustomerId(),HttpStatus.OK);
	}
	
	@GetMapping("/customer/{name}")
    private Customer getCustomerByName(@PathVariable("name") String name) throws ResourceNotFoundException{
	 return (Customer) customerServiceImpl.getCustomerByName(name);
	}
	
	@PutMapping("/customer")
	private String updateCustomer(@RequestBody Customer customer) {
	 customerServiceImpl.saveOrUpdate(customer);
	 return "Customer Updated Successfully";
	}
	
	@DeleteMapping("/customer/{id}")
    private void deleteCustomerById(@PathVariable("id") Long customerId) throws ResourceNotFoundException{
	 
	}

}
