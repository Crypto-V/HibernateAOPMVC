package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET /customers
	@GetMapping("/customers")
	private List<Customer> getCustomers() {

		return customerService.getCustomers();
	}

	// add mapping for get /customers/{customerId}. Returning a single customer.
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {

		Customer theCustomer = customerService.getCustomer(customerId);
		// If the customer is null wil throw and exception

		if (theCustomer == null)
			throw new CustomerNotFoundException("Customer id not found - " + customerId);

		return theCustomer;
	}

	// add mapping for post ./customers - add new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {

		// also just in case the pass and id in JSON -- set id to 0
		// this is force a save of new item .. instead of update.
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);

		return theCustomer;
	}

	// add mapping for PUT ./customers - update an existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);

		return theCustomer;
	}

	// add mapping for DELETE ./customers - DELETE an existing customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {

		// check if customer exists that delete if null throw exception
		Customer tempCustomer = customerService.getCustomer(customerId);
		if (tempCustomer == null)
			throw new CustomerNotFoundException("Customer id not found - " + customerId);

		customerService.deleteCustomer(customerId);

		return "Deleted customer id - " + customerId;
	}

}
