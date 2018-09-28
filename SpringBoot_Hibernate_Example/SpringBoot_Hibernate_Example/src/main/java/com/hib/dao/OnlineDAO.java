package com.hib.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hib.model.Customer;
import com.hib.model.Product;

@Repository
@Transactional
public class OnlineDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		return getSession().createQuery("from Customer").list();
	}


	public Long saveCustomer(Customer customer) {
		getSession().saveOrUpdate("customer", customer);
		return customer.getCustomerId();
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getAllProduct() {
		return getSession().createQuery("from Product").list();
	}


	public Long saveProduct(Product product) {
		getSession().saveOrUpdate("Product", product);
		return product.getProductId();
	}
}
