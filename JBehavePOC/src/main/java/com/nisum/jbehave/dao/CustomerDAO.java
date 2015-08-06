package com.nisum.jbehave.dao;

import java.util.List;

import com.nisum.jbehave.model.Customer;

public interface CustomerDAO {

	List<Customer> findCustomerByCompany(String company);
	
}
