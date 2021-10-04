package com.pos.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	
	   @Autowired
	   private CustomerRepository customerRepository;
	   
	   public boolean addCustomer(Customer customer) {
		      if(customer != null) {
		    	  return customerRepository.save(customer) != null ? true : false;
		      }
		      return false;
	   }
	   
	   

}
