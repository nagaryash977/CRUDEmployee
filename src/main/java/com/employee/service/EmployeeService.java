package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	// save data of single employee
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	// save multiple employee data
	public List<Employee> saveEmployees(List<Employee> employees) {
		return repository.saveAll(employees);
	}

	// fetch all details
	public List<Employee> getEmployees() {
		return repository.findAll();
	}

	// fetch details based on the id
	public Employee getEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}

	// delete employee by id
	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Employee removed !! " + id;
	}

	// update the employee details
	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
		existingEmployee.setName(employee.getName());
		existingEmployee.setDesignation(employee.getDesignation());
		existingEmployee.setCtc(employee.getCtc());
		existingEmployee.setCompany(employee.getCompany());
		return repository.save(existingEmployee);
	}

}
