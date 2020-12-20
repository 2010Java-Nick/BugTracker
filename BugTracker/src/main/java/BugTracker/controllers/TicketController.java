package BugTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import BugTracker.dtos.TicketDto;
import BugTracker.pojos.Ticket;
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
	@CrossOrigin
	@RequestMapping(path = "/ticket", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {

		ticketService.createTicket(ticketDto);

		ResponseEntity<TicketDto> rEntity = new ResponseEntity<TicketDto>(ticketDto, HttpStatus.CREATED);

		return rEntity;

	}
	


	
	@CrossOrigin
	@RequestMapping(path = "/opened/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TicketDto>> getAllTicketsByOpener(@PathVariable(name = "employeeId")@RequestBody long employeeId) {
		ResponseEntity<List<TicketDto>> rEntity = new ResponseEntity<List<TicketDto>>(ticketService.getDisplayAllTickets(ticketService.getAllTicketsByOpener(employeeId)), 
				HttpStatus.OK);
	
		return rEntity;
	}
	
	@CrossOrigin
	@RequestMapping(path = "/assigned/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TicketDto>> getAllTicketsByAssigned(@PathVariable(name = "employeeId") long employeeId) {
		ResponseEntity<List<TicketDto>> rEntity = new ResponseEntity<List<TicketDto>>(ticketService.getDisplayAllTickets(ticketService.getAllTicketsByAssigned(employeeId)), 
				HttpStatus.OK);
	
		return rEntity;
	}
	
	@CrossOrigin
	@RequestMapping(path = "/{ticketId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<TicketDto> getTicket(@PathVariable(name = "ticketId") long ticketId) {
		ResponseEntity<TicketDto> rEntity = new ResponseEntity<TicketDto>(ticketService.getTicket(ticketId).toDisplay(), 
				HttpStatus.OK);
	
		return rEntity;
	}
	
	//need to see all posts associated with a ticket
	
	

	@RequestMapping(path = "/tickets", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TicketDto>> getAllTickets(){
		ResponseEntity<List<TicketDto>> rEntity = new ResponseEntity<List<TicketDto>>(ticketService.getDisplayAllTickets(ticketService.getAllTickets()),
				HttpStatus.OK);
		return rEntity;
	}

}

