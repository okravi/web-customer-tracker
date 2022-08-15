package com.lc.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lc.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {

		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query, sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", 
						Customer.class);
		
		//get results from query
		List<Customer> customers = theQuery.getResultList();
		
		//return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {

		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//get results from db
		Customer theCustomer = currentSession.get(Customer.class, theId);
				
		//return results
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
						
		//delete customer
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	
	}

}
