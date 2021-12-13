package com.lti.bankingservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long customerId; 
	
	@Column (name = "name", nullable = false)
	String name;
	
	@Column (name = "address", nullable = false) 
	String address;
	
	@Column (name = "email", nullable = false)
	String email;	

	@Column (name = "mobile", nullable = false)
	String mobile;
	

	@Column (name = "accountType", nullable = false)
	String accountType;

	
	public Customer() {
		super();
	}


	public Customer(Long customerId, String name, String address, String email, String mobile, String accountType) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.accountType = accountType;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", mobile=" + mobile + ", accountType=" + accountType + "]";
	}
	
	
}
