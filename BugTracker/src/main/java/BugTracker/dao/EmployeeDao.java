package BugTracker.dao;

import BugTracker.dtos.CredentialsDTO;
import BugTracker.pojos.Employee;

/**
 * This is the interface for the basic CRUD methods for the employee table in the database.
 * @author Vincent
 *
 */

public interface EmployeeDao {
	
	public Employee createEmployee(Employee employee);
	
	public Employee readEmployeeById(long employeeId);
	
	public Employee readEmployeeByEmail(String email);
	
	public Employee readEmployeeByCredentials(CredentialsDTO credentials);
	
	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);

	public Employee findAssigned(long employeeId);
}
