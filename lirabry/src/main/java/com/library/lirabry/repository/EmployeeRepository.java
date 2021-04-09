package com.library.lirabry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.lirabry.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}