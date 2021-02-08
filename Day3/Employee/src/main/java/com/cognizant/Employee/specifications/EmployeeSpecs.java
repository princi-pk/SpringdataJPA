package com.cognizant.Employee.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.cognizant.Employee.model.Employee;
/*
public class EmployeeSpecs {
	
	
	public static Specification<Employee> getEmployeesByNameSpec(String name)
	{
		return new Specification<Employee>()
				{
					@Override
					public Predicate toPredicate(Root<Employee> root,CriteriaQuery<?> query,CriteriaBuilder criteriaBuilder)
					{
						Predicate equalPredicate=criteriaBuilder.equal(root.get(Employee_.name), name);
						return equalPredicate;
					}
						
				};
	}

}
*/