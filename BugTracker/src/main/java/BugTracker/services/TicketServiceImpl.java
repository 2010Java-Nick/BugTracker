package BugTracker.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import BugTracker.dao.EmployeeDao;
import BugTracker.dao.PostDao;
import BugTracker.dao.PriorityDao;
import BugTracker.dao.StatusDao;
import BugTracker.dao.TicketDao;
import BugTracker.dtos.TicketDto;
import BugTracker.pojos.Employee;
import BugTracker.pojos.Post;
import BugTracker.pojos.Priority;
import BugTracker.pojos.Status;
import BugTracker.pojos.Ticket;

@Service(value ="ticketService")
public class TicketServiceImpl implements TicketService {
	
	
	SessionFactory sessionFactory;

	TicketDao ticketDao;
	
	EmployeeService employeeService;
	
	PriorityDao priorityDao;
	
	StatusDao statusDao;
	
	PostDao postDao;
	
	EmployeeDao employeeDao;
	
	@Autowired
	@Qualifier(value = "employeeDao")
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Autowired
	@Qualifier(value = "statusDao")
	public void setStatusDao(StatusDao statusDao) {
		this.statusDao = statusDao;
	}
	
	@Autowired
	@Qualifier(value = "ticketDao")
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	@Autowired
	@Qualifier(value = "employeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	
	@Override
	public Ticket getTicket(long ticketId) {
		return ticketDao.readTicket(ticketId);
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketDao.getAllTickets();
	}

	@Override
	public List<Ticket> getAllTicketsByOpener(long employeeId) {
		return ticketDao.readTicketsByOpener(employeeId);
	}

	@Override
	public List<Ticket> getAllTicketsByAssigned(long employeeId) {
		return ticketDao.readTicketsByAssignedId(employeeId);
	}
	
	/**
	 * This method takes in a ticket DTO, transforms it
	 * into a ticket object, calls the ticket dao to create that ticket in the database,
	 * then returns the created ticket object
	 * @params TicketDto
	 * @returns ticket
	 * @author Hannah and Acacia 
	 */
	//TODO update testing for createTicket in Service
	@Override
	public Ticket createTicket(TicketDto ticketDto) {
		Employee opener = employeeService.getEmployee(ticketDto.getOpenerId());
		Priority priority = priorityDao.readPriorityById(ticketDto.getPriorityId());
		Status status = statusDao.readStatusById(1);
		ArrayList<Post> postList = new ArrayList<>();
		Post post = new Post(opener, ticketDto.getBody(), LocalDateTime.now());
		postList.add(post);
		
		//call dao
		
		Employee assigned = employeeService.findAssigned();
		
		int currentTickets = assigned.getNumTickets();
		currentTickets++;
		assigned.setNumTickets(currentTickets);
		
		employeeDao.updateEmployee(assigned);
		Ticket ticket = new Ticket(opener, ticketDto.getName(), LocalDateTime.now(),
				status, priority, ticketDto.getDifficultyLevel(), postList, assigned);
		Ticket newTicket = ticketDao.createTicket(ticket);
	
		return newTicket;
	}
	
	

	@Override
	public Ticket updateTicket( Ticket ticket) {
		return ticketDao.updateTicket(ticket);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		ticketDao.deleteTicket(ticket);
		
	}

	/**
	 * getPriorityObject takes in a priority ID, passes it to the DAO, and returns the object associated
	 * with that id
	 * @param long
	 * @returns Priority
	 * @author Acacia and Hannah
	 */
	@Override
	public Priority getPriorityObject(long priorityId) {
		return priorityDao.readPriorityById(priorityId);
	}
	
	

}
