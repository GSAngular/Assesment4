package com.lti.bankingservice.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.bankingservice.model.Customer;


@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query(value = "select c from Customer c where c.name=?1")
	Optional<Customer> findByNameContains(String name);

}
