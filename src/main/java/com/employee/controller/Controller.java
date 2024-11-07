package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;


@RestController
public class Controller {
	
	@Autowired
	private EmployeeService service;
	
	//Add single Employee
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return service.saveEmployee(employee);
	}
	
	//Add multiple Employee
	@PostMapping("/addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees)
	{
		return service.saveEmployees(employees);
	}
	
	//fetch details
	@GetMapping("/Employee")
	public List<Employee> findAllEmployee()
	{
		return service.getEmployees();
	}
	
	//fetch employee based on id
	@GetMapping("/Employee/{id}")
	public Employee FindEmployeeById(@PathVariable int id)
	{
		return service.getEmployeeById(id);
	}
	
	//update to the database
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		return service.updateEmployee(employee);
	}
	
	//delete the data based on id
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		return service.deleteEmployee(id);
	}
	
}
