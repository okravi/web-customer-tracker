package com.lc.springdemo.dao;

import java.util.List;

import com.lc.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
