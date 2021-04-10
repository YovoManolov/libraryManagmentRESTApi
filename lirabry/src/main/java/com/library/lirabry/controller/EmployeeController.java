package com.library.lirabry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Employee;
import com.library.lirabry.servicesImpl.EmployeeService;

public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
    	 List<Employee> employeeList = employeeService.getAllEmployees();
         return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/getOneById/{id}")
    public ResponseEntity<Employee> 
    	getEmployeeById(@PathVariable(value = "id") Long employeeId) throws RecordNotFoundException {
    	
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
   
    @PutMapping("/create")
	public ResponseEntity<Employee> createEmployee(
			@RequestBody Employee employee) {
    	
    		Employee createdEmployee = employeeService.createEmployee(employee);
    		return new ResponseEntity<Employee>(createdEmployee, HttpStatus.OK);
    	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(
			@RequestBody Employee newEmployee, @PathVariable Long id )
			throws RecordNotFoundException {
		Employee updatedEmployee = employeeService.updateEmployee(newEmployee,id);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}
}
