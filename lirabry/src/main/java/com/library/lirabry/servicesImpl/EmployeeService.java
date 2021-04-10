package com.library.lirabry.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Employee;
import com.library.lirabry.repository.EmployeeRepository;
import com.library.lirabry.services.EmployeeServiceI;

public class EmployeeService implements EmployeeServiceI {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> employeeList = employeeRepository.findAll();
		
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
	}

	@Override
	public Employee getEmployeeById(Long employeeId) throws RecordNotFoundException {
		
	    Optional<Employee> employee =  employeeRepository.findById(employeeId);
	    
	    if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
	}

	@Override
	public Employee createEmployee( Employee newEmployee) {
	     return employeeRepository.save(newEmployee);
	}

	@Override
	public Employee updateEmployee(Employee newEmployee, Long id ) {
	
			Function<Employee,Employee> updateEmployee = (employeeUpdated) -> {
				
				employeeUpdated.setBookLoans(newEmployee.getBookLoans());
				employeeUpdated.setDateOfEmployment(newEmployee.getDateOfEmployment());
				employeeUpdated.setFirstName(newEmployee.getFirstName());
				employeeUpdated.setLastName(newEmployee.getLastName());
				employeeUpdated.setPhoneNumber(newEmployee.getPhoneNumber());
				
				return employeeRepository.save(employeeUpdated);
			};
			
			Optional<Object> updatedEmployee = 
					employeeRepository.findById(id).map(updateEmployee);
				
			return (Employee) updatedEmployee.get();
	}
	
	@Override
	public boolean deleteEmployee(Long id) {
		if(employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
