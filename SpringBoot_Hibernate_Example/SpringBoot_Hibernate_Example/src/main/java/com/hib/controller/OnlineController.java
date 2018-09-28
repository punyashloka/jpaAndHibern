package com.hib.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hib.dao.OnlineDAO;
import com.hib.model.Customer;
import com.hib.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/online")
@Api(value="online")
public class OnlineController {
	@Autowired
	private OnlineDAO onlineDao;

	

	/*@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@RequestMapping(value = "/save", method= RequestMethod.POST)
	@ResponseBody
	public String create(String name, String city) {
		try {
			Person person = new Person();
			person.setName(name);
			person.setCity(city);
			personDao.savePerson(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully saved!";
	}*/
	
	@ApiOperation(value = "View a list of available customer", response = Iterable.class)
	@RequestMapping(value = "/allCustomer", method= RequestMethod.GET)
	@ResponseBody
	public List<Customer> getAllCustomer() {
		try {
			return onlineDao.getAllCustomer();
		} catch (Exception ex) {
			return null;
		}
	}
	
	@ApiOperation(value = "Savee customer")
	@RequestMapping(value = "/saveCustomer", method= RequestMethod.POST)
	@ResponseBody
	public Long saveCustomer(@RequestBody Customer customer, HttpServletRequest request, HttpServletResponse response) {
		try {
			return onlineDao.saveCustomer(customer);
		} catch (Exception ex) {
			return null;
		}
	}
	
	@ApiOperation(value = "View a list of available Product", response = Iterable.class)
	@RequestMapping(value = "/allProduct", method= RequestMethod.GET)
	@ResponseBody
	public List<Customer> getAllProduct() {
		try {
			return onlineDao.getAllProduct();
		} catch (Exception ex) {
			return null;
		}
	}
	
	@ApiOperation(value = "Savee Product")
	@RequestMapping(value = "/saveProduct", method= RequestMethod.POST)
	@ResponseBody
	public Long saveProduct(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response) {
		try {
			return onlineDao.saveProduct(product);
		} catch (Exception ex) {
			return null;
		}
	}
}
