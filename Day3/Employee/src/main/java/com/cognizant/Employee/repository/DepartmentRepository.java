package com.cognizant.Employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.Employee.model.Department;

public interface DepartmentRepository extends CrudRepository<Department,Integer> {

	public Department findById(int id);

}
