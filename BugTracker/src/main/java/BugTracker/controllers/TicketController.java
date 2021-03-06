package BugTracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import BugTracker.dtos.TicketDto;
import BugTracker.services.EmployeeService;
import BugTracker.services.TicketService;

@Controller
public class TicketController {
	TicketService ticketService;
	EmployeeService employeeService;

	@Autowired
	@Qualifier(value = "ticketService")
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@Autowired
	@Qualifier(value = "employeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * createTicket in Ticket controller takes in a ticketDTO from the front end,
	 * calls the service to create the ticket in the database, then creates a new
	 * response entity and returns that
	 * 
	 * @param ticketDto
	 * @return ResponseEntity<TicketDto>
	 * @author Acacia and Hannah
	 */
	// TODO test createTicket in Ticket Controller
	@RequestMapping(path = "/ticket", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {

		ticketService.createTicket(ticketDto);

		ResponseEntity<TicketDto> rEntity = new ResponseEntity<TicketDto>(ticketDto, HttpStatus.CREATED);

		return rEntity;

	}
}
