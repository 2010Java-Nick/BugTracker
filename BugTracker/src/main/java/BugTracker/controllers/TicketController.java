package BugTracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import BugTracker.pojos.Ticket;
import BugTracker.services.EmployeeService;
import BugTracker.services.TicketService;

public class TicketController {
	TicketService ticketService;
	EmployeeService employeeService;
	
	@Autowired
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public Ticket createTicket() {

	}	
}
