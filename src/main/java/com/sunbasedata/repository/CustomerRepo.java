package com.sunbasedata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbasedata.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
