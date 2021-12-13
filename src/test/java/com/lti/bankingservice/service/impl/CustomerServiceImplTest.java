package com.lti.bankingservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;

import com.lti.bankingservice.dao.CustomerRepository;
import com.lti.bankingservice.exception.ResourceNotFoundException;
import com.lti.bankingservice.model.Customer;


//@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerServiceImpl.class)
class CustomerServiceImplTest {
	
    @MockBean
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    private CustomerRepository custRepo;

	/*
	 * @BeforeAll static void setUpBeforeClass() throws Exception { }
	 * 
	 * @AfterAll static void tearDownAfterClass() throws Exception { }
	 * 
	 * @BeforeEach void setUp() throws Exception { }
	 * 
	 * @AfterEach void tearDown() throws Exception { }
	 */
	@Test
	void testGetAllCustomer() {
//		fail("Not yet implemented");
		when(custRepo.findAll()).thenReturn(Stream
				.of(new Customer(11188L, "ABC","India","abc@gmail.com","8888888888","Saving"),
						new Customer(11189L, "XYz","India","xyz@gmail.com","9990009990","current")).collect(Collectors.toList()));
		
	}


	@Test
	void testDeleteCustomerById() throws ResourceNotFoundException {
//		fail("Not yet implemented");
		Customer customer = new Customer(1L, "PQR","India","pqr@gmail.com","7778887877","Current");
		customerServiceImpl.deleteCustomerById(customer.getCustomerId());
		verify(custRepo, times(1)).delete(customer);	
	}

	@Test
	void testSaveOrUpdate() {
//		fail("Not yet implemented");
		Customer customer = new Customer(11187L, "PQR","India","pqr@gmail.com","7778887877","Current");
		when(custRepo.save(customer)).thenReturn(customer);
		assertEquals(customer, customerServiceImpl.saveOrUpdate(customer));	
	}

}
