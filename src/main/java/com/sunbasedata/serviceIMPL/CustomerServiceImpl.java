package com.sunbasedata.serviceIMPL;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunbasedata.model.Customer;
import com.sunbasedata.repository.CustomerRepo;
import com.sunbasedata.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust=customerRepo.save(customer);
		return cust;
	}

	@Override
	public String removeCustomer(int id) {
		customerRepo.deleteById(id);
		return "Deleted customer succesfully";
	}

	@Override
	public Optional<Customer> findCustomerById(int id) {
		Optional<Customer> cust= customerRepo.findById(id);
		if(cust.isPresent()) {
			return cust;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer>custList =customerRepo.findAll();
		return custList;
	}

	@Override
	public String updateCustomer(int id) {
		Optional<Customer>cust=customerRepo.findById(id);
		if(cust.isPresent()) {
			Customer custo=new Customer();
			customerRepo.save(custo);
			return "Updated Sucsessfully";
		}
		else {
			return "Customer not found";
		}
	}

}
