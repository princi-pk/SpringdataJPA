package com.cognizant.Employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Employee.model.Employee;
import com.cognizant.Employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee get(int id)
	{
		return employeeRepository.findById(id);	
		
	}
	
	@Transactional
	public void save(Employee employee)
	{
		employeeRepository.save(employee);	
		
	}

	@Transactional
	public List<Employee> getAllPermanentEmployees() {
		List<Employee> list=(List<Employee>)employeeRepository.findAll();
		return list;
	}
	
	@Transactional
	public double getAverageSalary(int id)
	{
		double avgsal=employeeRepository.getAverageSalary(id);
		return avgsal;
	}
	
	@Transactional
	public List<Employee> getAllEmployeesNative()
	{
		List<Employee> list=employeeRepository.getAllEmployeesNative();
		return list;
	}
	
	public List<Employee> findEmployeesByName(String name)
	{
		///List<Employee> list=employeeRepository.findAll(EmployeeSpecs.getEmployeesByNameSpec(name));
		//return list;
		List<Employee> list=employeeRepository.findEmployeesByName(name);
		//return null;
		return list;
	}

}
