package BugTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import BugTracker.dao.EmployeeDao;
import BugTracker.pojos.Employee;
import BugTracker.pojos.UserRole;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao employeeDao;
	
	@Autowired
	@Qualifier(value = "employeeDao")
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee getEmployee(long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateTicket(long employeeId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	
	public UserRole setUserRoleObject(long userRoleId) {
		
		
		
	}

}
