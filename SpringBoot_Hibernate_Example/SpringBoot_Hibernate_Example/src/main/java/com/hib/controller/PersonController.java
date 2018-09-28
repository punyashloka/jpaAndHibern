package com.hib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hib.dao.PersonDAO;
import com.hib.model.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/person")
@Api(value="person")
public class PersonController {
	@Autowired
	private PersonDAO personDao;

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@RequestMapping(value = "/delete", method= RequestMethod.DELETE)
	@ResponseBody
	public String delete(long id) {
		try {
			Person person = new Person();
			person.setId(id);
			personDao.delete(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully deleted!";
	}

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
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
	}
	
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@RequestMapping(value = "/allPersons", method= RequestMethod.GET)
	@ResponseBody
	public List<Person> getAllPersons() {
		try {
			return personDao.getAllPersons();
		} catch (Exception ex) {
			return null;
		}
	}
}
