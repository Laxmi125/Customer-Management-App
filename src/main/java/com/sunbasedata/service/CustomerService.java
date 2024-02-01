package com.sunbasedata.service;

import java.util.List;
import java.util.Optional;

import com.sunbasedata.model.Customer;

public interface CustomerService {
	public Customer addCustomer( Customer customer);
	public String removeCustomer(int id);
	public Optional<Customer> findCustomerById(int id);
	public List<Customer> getAllCustomer(); // List of all customers
	public String updateCustomer(int id);
}
