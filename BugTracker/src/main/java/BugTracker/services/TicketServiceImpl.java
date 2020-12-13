package BugTracker.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import BugTracker.dao.PriorityDao;
import BugTracker.dao.TicketDao;
import BugTracker.pojos.Priority;
import BugTracker.pojos.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	
	
	SessionFactory sessionFactory;

	TicketDao ticketDao;
	
	EmployeeService employeeService;
	
	PriorityDao priorityDao;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getAllTicketsByOpener(long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getAllTicketsByAssigned(long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * This method takes in a ticket, calls the ticket dao to create that ticket in the database,
	 * then returns the created ticket
	 * @params ticket
	 * @returns ticket
	 * @author Hannah and Acacia 
	 */
	@Override
	public Ticket createTicket(Ticket ticket) {
	
		return ticketDao.createTicket(ticket);
	}

	@Override
	public Ticket updateTicket(long ticketId, Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
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
