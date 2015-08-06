package com.nisum.jbehave.service;

import java.util.List;

import com.nisum.jbehave.model.Customer;

public interface CustomerService {
	
	boolean isValidRut(String rut, String dv);
	
	List<Customer> findCustomerByCompany(String company);

}
