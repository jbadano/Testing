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
		ArrayList<Customer> outCustomers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		customer.setRut("16080585");
		customer.setDv("4");
		customer.setCompany("nisum");
		customer.setName("Jorge");
		customer.setLastName("Badano");
		customer.setEmail("jbadano@nisum.com");
				
		Customer customer2 = new Customer();
		customer2.setRut("12075627");
		customer2.setDv("3");
		customer2.setCompany("nisum");
		customer2.setEmail("ebadano@nisum.com");
		customer2.setName("Emilio");
		customer2.setLastName("Badano");
		
		Customer customer3 = new Customer();
		customer3.setRut("5610902");
		customer3.setDv("1");
		customer3.setCompany("othercompany");
		customer3.setName("Juan");
		customer3.setEmail("email2@nisum.com");
		customer3.setLastName("Perez");
		
		customers.add(customer);
		customers.add(customer2);
		customers.add(customer3);
		
		for(Customer cust:customers){
			if(cust.getCompany().equalsIgnoreCase(company))
				outCustomers.add(cust);
		}
		
		
		return outCustomers;
	}

}
