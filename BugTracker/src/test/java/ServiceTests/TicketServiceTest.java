package ServiceTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import BugTracker.dao.TicketDaoImpl;
import BugTracker.pojos.Employee;
import BugTracker.pojos.Priority;
import BugTracker.pojos.Status;
import BugTracker.pojos.Ticket;
import BugTracker.pojos.UserRole;
import BugTracker.services.TicketServiceImpl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest {

	
	@Mock()
	TicketDaoImpl ticketDao;
	
	@InjectMocks
	TicketServiceImpl ticketService;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		UserRole developer = new UserRole("Developer", 2);
		Priority priority1 = new Priority("Urgent");
		Status opened = new Status("Opened");
		Employee employee1 = new Employee(91, "Acacia", "Holliday", "aholliday@gmail.com", 0, developer, 0);
		Employee employee2 = new Employee(92, "Hannah", "Novack", "hNovack@gmail.com", 0, developer, 0);
		Ticket ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(),opened, priority1, 3, employee2);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//Test Needs fixed
		UserRole developer = new UserRole("Developer", 2);
		Priority priority1 = new Priority("Urgent");
		Status opened = new Status("Opened");
		Employee employee1 = new Employee(91, "Acacia", "Holliday", "aholliday@gmail.com", 0, developer, 0);
		Employee employee2 = new Employee(92, "Hannah", "Novack", "hNovack@gmail.com", 0, developer, 0);
		Ticket ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(),opened, priority1, 3, employee2);
		when(ticketDao.createTicket(ticket)).thenReturn(ticket);
	
		//assertEquals(ticket, ticketService.createTicket(ticket));
		
	}
	
	@Test
	public void postListServiceTest() {
		
	}

}
