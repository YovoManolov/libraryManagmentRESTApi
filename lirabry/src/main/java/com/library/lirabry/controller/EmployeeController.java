package com.library.lirabry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Employee;
import com.library.lirabry.servicesImpl.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees() throws RecordNotFoundException {
		List<Employee> employeeList = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws RecordNotFoundException {

		Employee employee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

		Employee createdEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(createdEmployee, HttpStatus.CREATED);
	}

	@PutMapping(value="/{id}",
			consumes={ MediaType.APPLICATION_JSON_VALUE},
			produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id)
			throws RecordNotFoundException {

		Employee updatedEmployee = employeeService.updateEmployee(newEmployee, id);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployeeById(@PathVariable("id") Long employeeId)
			throws RecordNotFoundException {
		boolean result = employeeService.deleteEmployee(employeeId);
		if(result) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
