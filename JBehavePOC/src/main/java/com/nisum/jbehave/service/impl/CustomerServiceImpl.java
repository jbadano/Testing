package com.nisum.jbehave.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nisum.jbehave.dao.CustomerDAO;
import com.nisum.jbehave.model.Customer;
import com.nisum.jbehave.service.CustomerService;

@Component("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;

	public boolean isValidRut(String rut, String dv) {
		if(rut.isEmpty() || dv.isEmpty())
			return false;
			
		if("4".equals(dv))
			return true;
		
		return false;
		
	}

	public List<Customer> findCustomerByCompany(String company) {
		return customerDAO.findCustomerByCompany(company);
	}

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	
}
