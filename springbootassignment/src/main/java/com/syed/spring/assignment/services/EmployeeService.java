package com.syed.spring.assignment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syed.spring.assignment.entity.Employee;
import com.syed.spring.assignment.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;

	public Iterable<Employee> listAllEmployees() {
		return repo.findAll();
	}

	public Employee create(Employee employee) {
		return repo.save(employee);
	}

	public Employee update(Employee employee) {
		return repo.save(employee);
	}

	public Optional<Employee> read(int id) {
		return repo.findById(id);
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

}
