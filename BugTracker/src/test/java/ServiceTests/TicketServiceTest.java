package ServiceTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import BugTracker.dao.EmployeeDao;
import BugTracker.dao.PostDao;
import BugTracker.dao.PriorityDao;
import BugTracker.dao.StatusDao;
import BugTracker.dao.TicketDaoImpl;
import BugTracker.dao.UserRoleDao;
import BugTracker.dtos.TicketDto;
import BugTracker.pojos.Employee;
import BugTracker.pojos.Post;
import BugTracker.pojos.Priority;
import BugTracker.pojos.Status;
import BugTracker.pojos.Ticket;
import BugTracker.pojos.UserRole;
import BugTracker.services.EmployeeService;
import BugTracker.services.EmployeeServiceImpl;
import BugTracker.services.TicketServiceImpl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest {

	@Mock
	TicketDaoImpl ticketDao;

	@Mock
	EmployeeServiceImpl employeeService;

	@Mock
	PriorityDao priorityDao;

	@Mock
	StatusDao statusDao;

	@Mock
	PostDao postDao;

	@Mock
	EmployeeDao employeeDao;

	@Mock
	UserRoleDao userRoleDao;
	

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
		Ticket ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(), opened, priority1, 3, null,
				employee2);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		TicketDto testDto = new TicketDto(15, "Test Bug", 1, 1, 10, "Why am I so bad at testing");
		// Test Needs fixed
		UserRole developer = new UserRole("Developer", 2);

		Priority priority1 = new Priority(1, "Low");
		Status opened = new Status("Opened");
		when(priorityDao.readPriorityById(testDto.getPriorityId())).thenReturn(priority1);
		when(statusDao.readStatusById(testDto.getStatusId())).thenReturn(opened);
		Employee employee1 = new Employee(91, "Acacia", "Holliday", "aholliday@gmail.com", 0, developer, 0);
		Employee employee2 = new Employee(92, "Hannah", "Novack", "hNovack@gmail.com", 0, developer, 0);
		when(employeeService.getEmployee(testDto.getOpenerId())).thenReturn(employee1);
		when(employeeService.findAssigned()).thenReturn(employee2);
		Post post = new Post(employee1, "Why am I so bad at testing", LocalDateTime.now());
		List<Post> postList = new ArrayList<>();
		postList.add(post);
		Ticket ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(), opened, priority1, 10, postList,
				employee2);
		
		when(ticketDao.createTicket(Mockito.any(Ticket.class))).thenReturn(ticket);
		
		Ticket testTicket = ticketService.createTicket(testDto);
	

		assertEquals(ticket.getAssignedDeveloper(), testTicket.getAssignedDeveloper());

		assertEquals(ticket.getComments().get(0).getBody(),
				ticketService.createTicket(testDto).getComments().get(0).getBody());

	}

}
