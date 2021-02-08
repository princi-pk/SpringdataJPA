package com.cognizant.Employee.repository;

import java.util.List;

import com.cognizant.Employee.model.Employee;

public interface EmployeeRepositoryCustom {
	
	 List<Employee> findEmployeesByName(String name);

}
