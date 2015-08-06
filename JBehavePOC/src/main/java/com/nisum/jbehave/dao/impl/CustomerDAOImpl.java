package com.nisum.jbehave.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nisum.jbehave.dao.CustomerDAO;
import com.nisum.jbehave.model.Customer;

@Component("customerDAO")
public class CustomerDAOImpl implements CustomerDAO{

	public List<Customer> findCustomerByCompany(String company) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		customer.setRut("16080585");
		
		
		return customers;
	}

}
