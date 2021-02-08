package com.cognizant.Employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.Employee.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>,EmployeeRepositoryCustom{

	public Employee findById(int id);
	
	@Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1") 
	 public List<Employee> getAllPermanentEmployees();
	
	@Query(value="SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
	double getAverageSalary(@Param("id") int id);  
	
	 @Query(value="SELECT * FROM employee", nativeQuery = true)
	 List<Employee> getAllEmployeesNative();

}
