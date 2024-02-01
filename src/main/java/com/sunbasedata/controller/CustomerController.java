package com.sunbasedata.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunbasedata.model.Customer;
import com.sunbasedata.serviceIMPL.CustomerServiceImpl;

@RestController
@RequestMapping("/cust")

public class CustomerController {	
	@Autowired
	private CustomerServiceImpl custservice;
	
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to Sunbasedata Customer Management System ";
	}
	@PostMapping("/addCust")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer cust=custservice.addCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeCust{id}")
	public ResponseEntity<String> removeCustomer(@PathVariable int id){
		custservice.removeCustomer(id);
		
		return new ResponseEntity<String>("Removed successfully", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findCust{id}")
	public ResponseEntity< Optional<Customer>> findCustomerById(@PathVariable int id){
		
		Optional<Customer> custo=custservice.findCustomerById(id);
		
		return new ResponseEntity< Optional<Customer>>(custo,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> listOfCustomers(){
		
		List<Customer> lCust=custservice.getAllCustomer();
		
		return new ResponseEntity<List<Customer>>(lCust,HttpStatus.ACCEPTED);
	}
}
