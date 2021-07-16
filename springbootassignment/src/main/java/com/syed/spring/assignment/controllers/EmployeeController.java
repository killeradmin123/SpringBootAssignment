package com.syed.spring.assignment.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syed.spring.assignment.entity.Employee;
import com.syed.spring.assignment.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@GetMapping("/List")
	public Iterable<Employee> listAllEmployees() {
		return service.listAllEmployees();
	}

	@PostMapping("/create")
	public ResponseEntity<Employee> create(@Valid  @RequestBody Employee employee) {
		Employee savedEmployee = service.create(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}

	@PostMapping("/update")
	public ResponseEntity<Employee> update(@Valid @RequestBody Employee employee) {
		Employee savedEmployee = service.update(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/read/{id}")
	public Optional<Employee> read(@PathVariable("id") int id) {
		return service.read(id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}

}
