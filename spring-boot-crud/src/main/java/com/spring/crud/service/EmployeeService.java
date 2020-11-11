package com.spring.crud.service;

import java.util.List;

import com.spring.crud.model.dto.EmployeeDTO;

public interface EmployeeService {
	
	List<EmployeeDTO> getAllEmployees();

	void saveEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO getEmployeeById(long id);

	void deleteEmployeeById(long id);
}
