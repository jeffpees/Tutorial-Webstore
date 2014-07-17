package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;


@Repository
public class InMemoryCustomerRepository implements CustomerRepository{
  
  private List<Customer> listOfCustomers = new ArrayList<Customer>();
  
  public InMemoryCustomerRepository() {
	Customer cust1 = new Customer("C001","Tom","123 Block Drive",12);
	cust1.setCustomerId("C001");
	cust1.setName("Tom");
	cust1.setAddress("123 Block Dr");
	cust1.setNoOfOrdersMade(12);
    
    Customer cust2 = new Customer();
    cust2.setCustomerId("C002");
    cust2.setName("Billy");
    cust2.setAddress("124 Block Dr");
    cust2.setNoOfOrdersMade(43);
    
    Customer cust3 = new Customer();
    cust3.setCustomerId("C003");
    cust3.setName("Jill");
    cust3.setAddress("125 Block Dr");
    cust3.setNoOfOrdersMade(1);
    
    listOfCustomers.add(cust1);
    listOfCustomers.add(cust2);
    listOfCustomers.add(cust3);

  }

  public List<Customer> getAllCustomers() {
    return listOfCustomers;
  }
  
  public Customer getCustomerById(String customerId) {
	    Customer customerById = null;
	    
	    for(Customer customer : listOfCustomers) {
	      if(customer!=null && customer.getCustomerId()!=null && customer.getCustomerId().equals(customerId)){
	        customerById = customer;
	        break;
	      }
	    }
	    
	    if(customerById == null){
	      throw new IllegalArgumentException("No Customers found with the Customer id: "+ customerId);
	    }
	    
	    return customerById;
	}
}
