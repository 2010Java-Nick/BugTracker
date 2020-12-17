package BugTracker.services;

import java.util.List;

import BugTracker.pojos.Employee;


public interface EmployeeService {

	public Employee getEmployee(long employeeId);
	
	public List<Employee> getAllEmployees();
	
	public Employee createEmployee(Employee employee);

	public Employee updateTicket(long employeeId, Employee employee);
	
	public void deleteEmployee(Employee employee);

}
