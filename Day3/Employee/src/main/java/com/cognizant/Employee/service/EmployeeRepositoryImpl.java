package com.cognizant.Employee.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.cognizant.Employee.model.Employee;
import com.cognizant.Employee.repository.EmployeeRepositoryCustom;

@Service
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom{
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public List<Employee> findEmployeesByName(String name) {
		// TODO Auto-generated method stub
		 CriteriaBuilder cb = em.getCriteriaBuilder();

		  CriteriaQuery<Employee> q = cb.createQuery(Employee.class);
		  Root<Employee> c = q.from(Employee.class);
		  q.select(c).where(cb.equal(c.get("name"), name));
		  TypedQuery<Employee> query = em.createQuery(q);
		  List<Employee> results = query.getResultList();
		return results;
	}
	
	

}
