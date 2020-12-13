package DaoTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.hibernate.SessionFactory;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

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
public class TicketDaoTest {
	
	@Autowired
	public SessionFactoryUtil sessionFactoryUtil;
	

	public TicketDaoImpl ticketDao = new TicketDaoImpl(sessionFactoryUtil.getSessionFactoryUtil().getSessionFactory());
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
		Ticket ticket = new Ticket();
		
		when(ticketDao.createTicket(ticket));
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		UserRole developer = new UserRole("Developer", 2);
		Priority priority1 = new Priority("Urgent");
		Status opened = new Status("Opened");
		Employee employee1 = new Employee("Acacia", "Holliday", "aholliday@gmail.com", 0, developer);
		Employee employee2 = new Employee("Hannah", "Novack", "hNovack@gmail.com", 0, developer);
		Ticket ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(),opened, priority1, 3, null, employee2);
		Ticket returnedTicket = ticketDao.createTicket(ticket);
		assertEquals(returnedTicket, ticket);
	}

}
