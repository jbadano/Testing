package com.nisum.jbehave.main;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nisum.jbehave.model.Customer;
import com.nisum.jbehave.service.CustomerService;

public class JBehaveMain {

	final static Logger logger = LoggerFactory.getLogger(JBehaveMain.class);
	
	public static void main(String[] args) {
		logger.debug("Init JBehaveMain");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		ArrayList<Customer> customers = (ArrayList<Customer>) customerService.findCustomerByCompany("nisum");
		for(Customer cust : customers){
			System.out.println(cust.getRut());
		}
		logger.debug("End JBehaveMain");
	}

}
