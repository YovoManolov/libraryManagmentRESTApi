package com.library.lirabry.services;

import java.util.List;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Employee;

public interface EmployeeServiceI {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long employeeId) throws RecordNotFoundException;

	Employee createEmployee(Employee newEmployee);

	Employee updateEmployee(Employee newEmployee, Long id);

	boolean deleteEmployee(Long id);
}
