package com.syed.spring.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syed.spring.assignment.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
