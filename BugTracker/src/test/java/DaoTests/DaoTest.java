package DaoTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.hibernate.SessionFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import BugTracker.dao.EmployeeDaoImpl;
import BugTracker.dao.TicketDaoImpl;
import BugTracker.pojos.Employee;
import BugTracker.pojos.Priority;
import BugTracker.pojos.Status;
import BugTracker.pojos.Ticket;
import BugTracker.pojos.UserRole;
import BugTracker.utils.SessionFactoryUtil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class DaoTest {
	
	@Autowired
	public SessionFactoryUtil sessionFactoryUtil;
	
	public EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(sessionFactoryUtil.getSessionFactoryUtil().getSessionFactory());
	public TicketDaoImpl ticketDao = new TicketDaoImpl(sessionFactoryUtil.getSessionFactoryUtil().getSessionFactory());
	
	private Employee employee1;
	private Employee employee2;
	private UserRole role;
	private Status status;
	private Priority priority1;
	private Ticket ticket;
	private long employee1Id;
	private long employee2Id;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		role = new UserRole("Developer", 2);
		priority1 = new Priority("Urgent");
		status= new Status("Opened");
		employee1 = new Employee("Acacia", "Holliday", "aholliday@gmail.com", 0, role);
		employee2 = new Employee("Hannah", "Novack", "hNovack@gmail.com", 0, role);
		employeeDao.createEmployee(employee1);
		employeeDao.createEmployee(employee2);
		employee1Id = employee1.getEmployeeId();
		employee2Id = employee1.getEmployeeId();

		
		ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(),status, priority1, 3, null, employee2);

		
	}

	@After
	public void tearDown() throws Exception {
		long ticketId = ticket.getTicketId();
		if (ticketDao.readTicket(ticketId) != null) {
			ticketDao.deleteTicket(ticket);
		}
		if (employeeDao.readEmployeeById(employee1Id) != null && 
				employeeDao.readEmployeeById(employee2Id) != null) {
		employeeDao.deleteEmployee(employee1);
		employeeDao.deleteEmployee(employee2);
		}
	}

	@Test
	public void createTicketTest() {
		
		
		
		Ticket returnedTicket = ticketDao.createTicket(ticket);
		assertEquals(returnedTicket, ticket);
	}
	
	@Test
	public void deleteTicketTest() {
		Ticket ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(),status, priority1, 3, null, employee2);
		ticketDao.createTicket(ticket);
		long ticketId = ticket.getTicketId();
		ticketDao.deleteTicket(ticket);
		assertNull(ticketDao.readTicket(ticketId));
		
	}

}
