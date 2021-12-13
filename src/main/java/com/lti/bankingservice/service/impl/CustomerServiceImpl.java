package com.lti.bankingservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bankingservice.services.CustomerService;
import com.lti.bankingservice.dao.CustomerRepository;
import com.lti.bankingservice.exception.ResourceNotFoundException;
import com.lti.bankingservice.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customer -> customerList.add(customer));
		return customerList;
	}

	@Override
	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByNameContains(name).get();		
	}

	@Override
	public void deleteCustomerById(Long customerId)  throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer Not Found With this Id"));
		customerRepository.delete(customer);
		
	}

	@Override
	public Customer saveOrUpdate(Customer customer) {
		// TODO Auto-generated method stub
		
		Customer newCustomer= new Customer();
		if(customer.getCustomerId()!= null) {
			newCustomer.setCustomerId(customer.getCustomerId());
		}
		newCustomer.setName(customer.getName());
		newCustomer.setMobile(customer.getEmail());
		newCustomer.setEmail(customer.getEmail());
		newCustomer.setAddress(customer.getAddress());
		newCustomer.setAccountType(customer.getAccountType());
		return customer;
	}

}
