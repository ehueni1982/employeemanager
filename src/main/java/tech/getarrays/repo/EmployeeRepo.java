package tech.getarrays.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.getarrays.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	
}
