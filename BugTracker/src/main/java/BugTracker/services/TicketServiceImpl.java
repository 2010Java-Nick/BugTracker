package BugTracker.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

@Service
public class TicketServiceImpl implements TicketService {
	
	
	SessionFactory sessionFactory;

	TicketDao ticketDao;
	
	EmployeeService employeeService;
	
	PriorityDao priorityDao;
	
	StatusDao statusDao;
	
	PostDao postDao;
	
	
	
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
		Employee assigned = employeeService.getEmployee(ticketDto.getAssignedDeveloperId());
		Priority priority = priorityDao.readPriorityById(ticketDto.getPriorityId());
		Status status = statusDao.readStatusById(ticketDto.getStatusId());
		List<Post> postList = new ArrayList<>();
		
		for (long postId: ticketDto.getCommentIds()) {
			postList.add(postDao.readPost(postId));
		}
		
		Ticket ticket = new Ticket(opener, ticketDto.getName(), ticketDto.getCreated(),
				status, priority, ticketDto.getDifficultyLevel(), postList, assigned);
	
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
