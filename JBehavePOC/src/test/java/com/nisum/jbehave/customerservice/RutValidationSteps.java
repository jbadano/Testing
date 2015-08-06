package com.nisum.jbehave.customerservice;

import javax.annotation.Resource;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nisum.jbehave.model.Customer;
import com.nisum.jbehave.service.CustomerService;

@Component
public class RutValidationSteps {
	
	@Resource(name = "customerService")
	CustomerService customerService;
	
	private Customer customer;
	private boolean resultValidation;
	
	@BeforeScenario
    public void beforeScenario() {
        this.customer = null;
        this.resultValidation = false;
    }
	
	
	@Given("A customer into application")			
    public void givenACustomerIntoApplication() { 
		
		customer = new Customer();
		
		
	}

    @When("Customer have the rut $rut")
    public void whenCustomerHaveTheRut(@Named("rut") String rut) { customer.setRut(rut); }

    @When("Customer have the dv $dv")
    public void whenCustomerHaveTheDv(@Named("dv") String dv) { customer.setDv(dv); }
    
    @When("The rut validation is requested")
    public void rutValidationIsRequested(){
    	this.resultValidation = customerService.isValidRut(customer.getRut(), customer.getDv());
    }
    
    @Then("The rut validation should return $result")
    public void thenIShouldCount(@Named("result") boolean result) {
        Assert.assertEquals(result, this.resultValidation);
    }


	public CustomerService getCustomerService() {
		return customerService;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public boolean isResultValidation() {
		return resultValidation;
	}


	public void setResultValidation(boolean resultValidation) {
		this.resultValidation = resultValidation;
	}
    
    
    
}
