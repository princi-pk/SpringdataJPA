package com.cognizant.Employee.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Employee.model.Skill;
import com.cognizant.Employee.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Transactional
	public Skill get(int id)
	{
		return skillRepository.findById(id);	
		
	}
	
	@Transactional
	public void save(Skill skill)
	{
		skillRepository.save(skill);	
		
	}


}
