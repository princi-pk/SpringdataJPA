package com.cognizant.Employee;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.Employee.model.Department;
import com.cognizant.Employee.model.Employee;
import com.cognizant.Employee.model.Skill;
import com.cognizant.Employee.service.DepartmentService;
import com.cognizant.Employee.service.EmployeeService;
import com.cognizant.Employee.service.SkillService;


@SpringBootApplication
public class EmployeeApp{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeApp.class);
	
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	
	

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(EmployeeApp.class, args);
		
		employeeService=context.getBean(EmployeeService.class);
		departmentService=context.getBean(DepartmentService.class);
		skillService=context.getBean(SkillService.class);
		
	/*	LOGGER.info("Start");
		 LOGGER.info("Get Employee By Id:"); 
		Employee e=employeeService.get(1);		
		 LOGGER.debug("employee:{}",e);
		 LOGGER.info("End"); 
		 
		 

		LOGGER.info("Start");
		LOGGER.info("Insert new Employee:"); 
		 Employee e1=new Employee();
		 e1.setDateOfBirth(new Date());
		 e1.setName("xyz");
		 e1.setPermanent(true);
		 e1.setSalary(200000);
		 employeeService.save(e1);
		 LOGGER.info("End"); 
		 
		 System.out.println(departmentService.get(1));		
		testGetEmployee();
		*/
		//testUpdateEmployee();
		//testGetDepartment();
		//testGetEmployee();
		//testAddSkillToEmployee();
		//testGetAllPermanentEmployees();
		//testGetAverageSalary();
		//testAllEmployeesNative();
		testFindEmployeesByName();
	}
	
	private static void testGetEmployee() {
		
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");

	}
	
	public static void testAddEmployee()
	{
		LOGGER.info("Start");
		LOGGER.info("Insert new Employee:");
		Employee employee=new Employee();
		employee.setDateOfBirth(new Date());
		employee.setName("sanky");
		employee.setPermanent(true);
		employee.setSalary(100000);
		employee.setDepartment(departmentService.get(1));		
		employeeService.save(employee);
		LOGGER.info("End");		
				
	}
	
	public static void testUpdateEmployee()
	{
		LOGGER.info("Start");	
		LOGGER.info("Before update:");
		Employee e=employeeService.get(1);
		LOGGER.debug("employee:{}",e);
		Department d=departmentService.get(3);
		
		e.setDepartment(d);		
		employeeService.save(e);
		LOGGER.info("After update:");
		LOGGER.info("employee:{}",e);
		LOGGER.info("End");	
		
		
	}
	
	public static void testGetDepartment()
	{
		Department department=departmentService.get(3);
		LOGGER.debug("department:{}",department);
		Set<Employee> employees=department.getEmployeeList();		
		LOGGER.debug("employees:{}",employees);
	}
	
	public static void  testAddSkillToEmployee()
	{
		Employee e=employeeService.get(4);
		Skill s=skillService.get(1);
		
		Set<Skill> skillList = e.getSkillList();
		skillList.add(s);
		
		employeeService.save(e);
		
	}
	
	 public static void testGetAllPermanentEmployees() {

		 LOGGER.info("Start");
		 List<Employee> employees = employeeService.getAllPermanentEmployees();
		 LOGGER.debug("Permanent Employees:{}", employees);
		 employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		 LOGGER.info("End");

		 } 
	 
	 public static void testGetAverageSalary() {
		 LOGGER.info("Start");
		 LOGGER.debug("Avg Salary:{}", employeeService.getAverageSalary(1));
		 LOGGER.info("End");
	 
	 }
	 
	 public static void testAllEmployeesNative() {
		 LOGGER.info("Start");
		 LOGGER.debug("Employees:{}", employeeService.getAllEmployeesNative());
		 LOGGER.info("End");
	 
	 }
	 
	 public static void testFindEmployeesByName()
	 {
		 LOGGER.info("Start");
		 LOGGER.debug("Employees:{}", employeeService.findEmployeesByName("Jack"));
		 LOGGER.info("End");		 
	 }
	
}
