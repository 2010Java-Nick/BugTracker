package DaoTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.hibernate.SessionFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import BugTracker.config.AppConfig;
import BugTracker.dao.EmployeeDao;
import BugTracker.dao.EmployeeDaoImpl;
import BugTracker.dao.TicketDao;
import BugTracker.dao.TicketDaoImpl;
import BugTracker.dao.UserRoleDao;
import BugTracker.dao.UserRoleDaoImpl;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)

public class DaoTest {
	
	
	@Autowired
	public SessionFactoryUtil sessionFactoryUtil;
	
	@Autowired
	EmployeeDaoImpl employeeDao;
	
	@Autowired
	TicketDaoImpl ticketDao;
	
	@Autowired
	UserRoleDaoImpl userRoleDao;
	
	
	private Employee employee1;
	private Employee employee2;
	private UserRole role1;
	private UserRole role2;
	private Status status;
	private Priority priority1;
	private Ticket ticket;
	private long ticketId;
	private long employee1Id;
	private long employee2Id;
	private long roleId1;
	private long roleId2;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		role1 = new UserRole("Employee", 1);
		role2 = new UserRole("Developer", 2);
		priority1 = new Priority("Urgent");
		status= new Status("Opened");
		employee1 = new Employee("Acacia", "Holliday", "aholliday@gmail.com", 0, role1);
		employee2 = new Employee("Hannah", "Novack", "hNovack@gmail.com", 0, role2);
		employeeDao.createEmployee(employee1);
		employeeDao.createEmployee(employee2);
		employee1Id = employee1.getEmployeeId();
		employee2Id = employee2.getEmployeeId();
		

		
		ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(),status, priority1, 3, null, employee2);

		
	}

	@After
	public void tearDown() throws Exception {
		/**
		 * You have to delete the ticket before the employee before the role
		 */
	
		ticketId = ticket.getTicketId();
		System.out.println(ticketId);
		if (ticketDao.readTicket(ticketId) != null) {
			ticketDao.deleteTicket(ticket);
		}
		
		employee1Id = employee1.getEmployeeId();
		employee2Id = employee2.getEmployeeId();
		System.out.println(employee1Id);
		System.out.println(employee2Id);
		if (employeeDao.readEmployeeById(employee1Id) != null) {
			System.out.println("***Checking to see if inside Employee If Statement AHHHHHHHHHHH");
			employeeDao.deleteEmployee(employee1);
		}
		if (employeeDao.readEmployeeById(employee2Id) != null) {
					
					System.out.println("Before employee2");
					employeeDao.deleteEmployee(employee2);
					System.out.println("After employee 2?");
			}
		
		
//		roleId = role.getRoleId();
//		System.out.println(roleId);
//		if (userRoleDao.readUserRole(roleId)!= null) {
//			userRoleDao.deleteUserRole(role);
//		}
		
	
	
		
		
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
	
	@Test
	public void createUserRoleTest() {
//		UserRole returnedRole = userRoleDao.createUserRole(role);
//		roleId = returnedRole.getRoleId();
//		assertEquals(returnedRole, role);
		
		
	}
	
	@Test
	public void readUserRoleTest() {
		
	}
	
	@Test
	public void createPriorityTest() {
		
	}
	
	@Test
	public void readPriorityTest() {
		
	}
	
	@Test
	public void createStatusTest() {
		
	}

	@Test
	public void readStatusTest() {
		
	}
}
