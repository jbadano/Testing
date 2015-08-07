package com.nisum.jbehave.customerservice;

import java.util.List;

import javax.annotation.Resource;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.stereotype.Component;

import com.nisum.jbehave.dao.CustomerDAO;
import com.nisum.jbehave.model.Customer;
import com.nisum.jbehave.service.CustomerService;

@Component
public class FindCustomerSteps {
	
	@Resource(name = "customerService")
	CustomerService customerService;
	
	private List<Customer> customers;
	private String company;
	
	@BeforeScenario
    public void beforeScenario() {
        this.customers = null;
        this.company = null;
    }
	
	
	@Given("A company name $companyName")			
    public void givenACompanyName(@Named("companyName") String companyName) { 		
		this.company = companyName;				
	}

    @When("Start to find by company")
    public void whenStartFindByCompany(){ 
    	
    }
        
    @Then("The customers obtained are $customerTable")
    public void thenIShouldObtainCustomers(@Named("customerTable") ExamplesTable customerTable) {
        
    }


	public CustomerService getCustomerService() {
		return customerService;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


}
