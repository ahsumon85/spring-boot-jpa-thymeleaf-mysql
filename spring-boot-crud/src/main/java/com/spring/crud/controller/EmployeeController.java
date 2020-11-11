package com.spring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.crud.model.dto.EmployeeDTO;
import com.spring.crud.model.entity.Employee;
import com.spring.crud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// display list of employees
	@GetMapping("/")
	public ModelAndView viewHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listEmployees", employeeService.getAllEmployees());
		modelAndView.setViewName("index");
		return modelAndView;
	}

	// create model attribute to bind form data
	@GetMapping("/showNewEmployeeForm")
	public ModelAndView showNewEmployeeForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeDTO", new EmployeeDTO());
		modelAndView.setViewName("new_employee");
		return modelAndView;
	}

	// save employee to database
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO) {
		employeeService.saveEmployee(employeeDTO);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public ModelAndView showFormForUpdate(@PathVariable(value = "id") long id) {
		ModelAndView modelAndView = new ModelAndView();
		// get employee from the service
		EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);

		// set employee as a model attribute to pre-populate the form
		modelAndView.addObject("employeeDTO", employeeDTO);
		modelAndView.setViewName("update_employee");
		return modelAndView;
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}

}
