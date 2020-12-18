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

@Service(value = "ticketService")
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

	@Autowired
	@Qualifier(value = "priorityDao")
	public void setPriorityDao(PriorityDao priorityDao) {
		this.priorityDao = priorityDao;
	}

	@Autowired
	@Qualifier(value = "postDao")
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
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
	 * This method takes in a ticket DTO, transforms it into a ticket object, calls
	 * the ticket dao to create that ticket in the database, then returns the
	 * created ticket object
	 * 
	 * @params TicketDto
	 * @returns ticket
	 * @author Hannah and Acacia
	 */
	// TODO update testing for createTicket in Service
	@Override
	public Ticket createTicket(TicketDto ticketDto) {

		Employee opener = employeeDao.readEmployeeById(ticketDto.getOpenerId());
		Priority priority = priorityDao.readPriorityById(ticketDto.getPriorityId());
		Status status = statusDao.readStatusById(1);

		// call dao

		Employee assigned = employeeDao.findAssigned(opener.getEmployeeId());

		int currentTickets = assigned.getNumTickets();
		currentTickets++;
		assigned.setNumTickets(currentTickets);

		employeeDao.updateEmployee(assigned);
		Ticket ticket = new Ticket(opener, ticketDto.getName(), LocalDateTime.now(), status, priority,
				ticketDto.getDifficultyLevel(), assigned);

		ticketDao.createTicket(ticket);
		Post post = new Post(opener, ticketDto.getBody(), LocalDateTime.now(), ticket);
		postDao.createPost(post);

		return ticket;

	}

	private Employee assignEmployee(int difficultyLevel) {

		// select all from bug_tracker_employee where exp_points > difficultyLevel * 10
		// select employee with least number of experience points and

		return null;
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
	 * getPriorityObject takes in a priority ID, passes it to the DAO, and returns
	 * the object associated with that id
	 * 
	 * @param long
	 * @returns Priority
	 * @author Acacia and Hannah
	 */
	@Override
	public Priority getPriorityObject(long priorityId) {
		return priorityDao.readPriorityById(priorityId);
	}

}
