package BugTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import BugTracker.pojos.Employee;
import BugTracker.services.EmployeeService;

@Controller
public class EmployeeController {
	EmployeeService employeeService;
	
	@Autowired
	@Qualifier(value = "employeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@CrossOrigin
	@RequestMapping(path = "/leaderboard", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> viewLeaderBoard(){
		return employeeService.viewLeaderBoard();
	}
}
