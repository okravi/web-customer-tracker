package com.lc.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lc.springdemo.dao.CustomerDAO;
import com.lc.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the DAO
	@Autowired
	private CustomerDAO customerDao;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customerss from the dao
		List<Customer> theCustomers = customerDao.getCustomers();
		
		//add customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}
