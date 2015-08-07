package com.nisum.jbehave.customerservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.steps.Parameters;
import org.springframework.stereotype.Component;

import com.nisum.jbehave.dao.CustomerDAO;
import com.nisum.jbehave.model.Customer;
import com.nisum.jbehave.service.CustomerService;

@Component
public class FindCustomerSteps {
	
	@Resource(name = "customerService")
	CustomerService customerService;
	
	private List<Map<String, String>> results;	
	private String company;
	
	@BeforeScenario
    public void beforeScenario() {
        this.results = null;
        this.company = null;
    }
	
	
	@Given("A company name $companyName")			
    public void givenACompanyName(@Named("companyName") String companyName) { 		
		this.company = companyName;				
	}

    @When("Start to find by company")
    public void whenStartFindByCompany(){ 
    	List<Customer> customers = customerService.findCustomerByCompany(this.company);
    	results = new ArrayList<Map<String, String>>();
    	for(Customer cust:customers){
    		Map<String, String> customer = new HashMap<String, String>();
    		customer.put("rut", cust.getRut());
    		customer.put("dv", cust.getDv());
    		customer.put("name", cust.getName());
    		customer.put("lastName", cust.getLastName());
    		customer.put("email", cust.getEmail());
    		customer.put("company", cust.getCompany());
    		this.results.add(customer);
    	}
    }
        
    @Then("The customers obtained are $customerTable")
    public void thenIShouldObtainCustomers(@Named("customerTable") ExamplesTable customerTable) {
    	OutcomesTable expected = new OutcomesTable();
        for (int i = 0; i < results.size();i++) {
            Parameters row = customerTable.getRowAsParameters(i);
            Map<String, String> actual = results.get(i);
            for (String key : actual.keySet()) {
                expected.addOutcome(key, actual.get(key), (Matchers.equalTo(row.valueAs(key, String.class))));
            }
        }
        expected.verify();
    }


	public CustomerService getCustomerService() {
		return customerService;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


}
