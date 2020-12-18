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
	private UserRole basic;
	private UserRole developer;
	private UserRole createRole;
	private Status status;
	private Priority priority1;
	private Ticket ticket;
	private long ticketId;
	private long employee1Id;
	private long employee2Id;
	private UserRole testRole;
	private long testRoleId;
	private long testRoleId1;
	private long createRoleId;



	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {

		testRole = new UserRole("Test", 90);
		createRole = new UserRole("Create", 99);
		userRoleDao.createUserRole(testRole);
		developer = userRoleDao.readUserRole(2);
		basic = userRoleDao.readUserRole(1);
		employee1 = new Employee("Acacia", "Holliday", "aholliday@gmail.com", 0, basic, 0);
		employee2 = new Employee("Hannah", "Novack", "hNovack@gmail.com", 0, developer, 0);
		employeeDao.createEmployee(employee1);
		employeeDao.createEmployee(employee2);
		employee1Id = employee1.getEmployeeId();
		employee2Id = employee2.getEmployeeId();
		

		
		ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(),status, priority1, 3, employee2);

		
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

		if (employeeDao.readEmployeeById(employee1Id) != null) {
			employeeDao.deleteEmployee(employee1);
		}
		if (employeeDao.readEmployeeById(employee2Id) != null) {
					
					System.out.println("Before employee2");
					employeeDao.deleteEmployee(employee2);
					System.out.println("After employee 2?");
			}
		
		
		testRoleId = testRole.getRoleId();
		
		if (userRoleDao.readUserRole(testRoleId) != null) {
			System.out.println("Test role Id = " + testRoleId);
			userRoleDao.deleteUserRole(testRole);
		}
		
		createRoleId = createRole.getRoleId();
		
		if (userRoleDao.readUserRole(createRoleId) != null) {
			System.out.println("Create role Id = " + createRoleId);
			userRoleDao.deleteUserRole(createRole);
		}
		
		
	
	
		
		
	}

	@Test
	public void createTicketTest() {
		
		
		
		Ticket returnedTicket = ticketDao.createTicket(ticket);
		assertEquals(returnedTicket, ticket);
	}
	
	@Test
	public void deleteTicketTest() {
		Ticket ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(),status, priority1, 3, employee2);
		ticketDao.createTicket(ticket);
		long ticketId = ticket.getTicketId();
		ticketDao.deleteTicket(ticket);
		assertNull(ticketDao.readTicket(ticketId));
		
	}
	
	@Test
	public void createUserRoleTest() {
		UserRole returnedRole = userRoleDao.createUserRole(createRole);
		//createRoleId = returnedRole.getRoleId();
		assertEquals(returnedRole, createRole);
		
		
	}
	
	@Test
	public void readUserRoleTest() {
		UserRole readRole;
		readRole = userRoleDao.readUserRole(1);
		assertEquals(readRole, new UserRole(1, "Basic", 1));
		
	}
	
	@Test
	public void deleteUserRoleTest() {
		userRoleDao.deleteUserRole(testRole);
		assertNull(userRoleDao.readUserRole(testRoleId1));
	}
	
	@Test
	public void findAssignedTest() {
		Employee employee = employeeDao.findAssigned(employee1.getEmployeeId());
		assertEquals(employee, employee1);
	}
	

}
