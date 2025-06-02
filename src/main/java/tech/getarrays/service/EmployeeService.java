package tech.getarrays.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.exception.UserNotFoundException;
import tech.getarrays.model.Employee;
import tech.getarrays.repo.EmployeeRepo;
@Service
public class EmployeeService {
	

	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo=employeeRepo;
	}
	
	//Create Employee
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	//Show All Employee list
	
	public List<Employee>findAllEmployee(){
		
		return employeeRepo.findAll();
		
	}
	
	//Update
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	//Find Employee by id 
	/*
	 * public Optional<Employee> findEmployeeById(Long id) { return
	 * employeeRepo.findById(id); }
	 */
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}
	
	//delete
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
}
