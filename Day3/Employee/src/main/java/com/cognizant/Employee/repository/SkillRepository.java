package com.cognizant.Employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.Employee.model.Skill;

public interface SkillRepository extends CrudRepository<Skill,Integer> {

	public Skill findById(int id);

}
