package com.capgermini.Controller;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgermini.DAO.DaoClass;
import com.capgermini.DemoApp.PersonProperties;

@RequestMapping("/")
@RestController
public class DemoController {

	@Autowired
	private DaoClass dao;

	private PersonProperties personProperties;

	@Autowired
	public void ConfigurationPropertiesApplication(PersonProperties personProperties) {
		this.personProperties = personProperties;
	}

	@GetMapping("/")
	public String helloMethod() {

		return "HELLO CAPGEMINI Bangalore ...!!!!";
	}

	@RequestMapping("/props")
	public String greetings() {
		return personProperties.getGreeting() + " Spring Boot! " + personProperties.getFarewell() + " Spring Boot!";
	}

	@GetMapping("/store")
	public String storeDB(@PathParam("name") String name) {
		return dao.store(name);
	}

	@GetMapping("/get")
	public List<Map<String, Object>> getMethod() {

		return dao.get();
	}

}
