package com.spring.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.spring.crud.model.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	Employee getEmployeeById(long id);

	void deleteEmployeeById(long id);
}
