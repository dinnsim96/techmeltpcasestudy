package com.spring.springcore.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.springcore.entity.Employee;
import com.spring.springcore.service.EmployeeService;

/**
 *  Main Controller for the application.
 *  <p>
 *  This controller's default mapping is "/", 
 *  which accessed through localhost:<port>/
 *  
 *  @author
 *  	Nazreen Misrawi
 */



@Controller
@RequestMapping("/")
public class EmployeeController {
	
	
	/**
	 *  Autowire the EmployeeService.
	 *  <p>
	 *  This will be used to access the Employee DAO
	 *  
	 *  @author
	 *  	Nazreen Misrawi
	 */
	
	@Autowired
	EmployeeService service;
	
	/**
	 *  Controller for the root location of the API.
	 *  <p>
	 *  Since no path is specified in the GetMapping annotation,
	 *  the mapping of the controller class, "/", is used. Similarly,
	 *  This URI can be accessed by localhost:<port>/
	 *  <p>
	 *  @param model The view of the mapping, or web page.
	 *  @param principal Principal stores the information of the current logged in user.
	 *  @return Returns the view list-employees
	 */
	
	@GetMapping
	public String getAllEmployees(Model model, Principal principal) {
		List<Employee> list = service.getEmployees();
		model.addAttribute("employees", list);
		model.addAttribute("loggedInAs", "You are logged in as " + principal.getName());
		return "list-employees";
	}
	
}
