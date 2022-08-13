package com.lc.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.springdemo.dao.CustomerDAO;
import com.lc.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//inject CustomerDAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerDAO.getCustomers();
	}

}
