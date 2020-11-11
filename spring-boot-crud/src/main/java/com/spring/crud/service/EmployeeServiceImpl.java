package com.spring.crud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.model.dto.EmployeeDTO;
import com.spring.crud.model.entity.Employee;
import com.spring.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(empl -> copyEmployeeEntityToDto(empl)).collect(Collectors.toList());
	}

	@Override
	public void saveEmployee(EmployeeDTO employeeDTO) {
		employeeRepository.save(copyEmployeeDtoToEntity(employeeDTO));
	}

	@Override
	public EmployeeDTO getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		EmployeeDTO employeeDTO = null;
		if (optional.isPresent()) {
			employeeDTO = copyEmployeeEntityToDto(optional.get());
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employeeDTO;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}

	public Employee copyEmployeeDtoToEntity(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDTO, employee);
		return employee;
	}

	public EmployeeDTO copyEmployeeEntityToDto(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employee, employeeDTO);
		return employeeDTO;
	}

}
