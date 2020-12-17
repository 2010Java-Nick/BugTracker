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
<<<<<<< HEAD
		role1 = new UserRole("Employee", 1);
		role2 = new UserRole("Developer", 2);
		priority1 = new Priority("Urgent");
		status = new Status("Opened");
		employee1 = new Employee("Acacia", "Holliday", "aholliday@gmail.com", 0, role1);
		employee2 = new Employee("Hannah", "Novack", "hNovack@gmail.com", 0, role2);
=======

		testRole = new UserRole("Test", 90);
		createRole = new UserRole("Create", 99);
		userRoleDao.createUserRole(testRole);
		developer = userRoleDao.readUserRole(2);
		basic = userRoleDao.readUserRole(1);
		employee1 = new Employee("Acacia", "Holliday", "aholliday@gmail.com", 0, basic );
		employee2 = new Employee("Hannah", "Novack", "hNovack@gmail.com", 0, developer );
>>>>>>> 173611f9e293e5b150de55fca0c423d783177c76
		employeeDao.createEmployee(employee1);
		employeeDao.createEmployee(employee2);
		employee1Id = employee1.getEmployeeId();
		employee2Id = employee2.getEmployeeId();

		ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(), status, priority1, 3, null, employee2);

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
<<<<<<< HEAD

			System.out.println("Before employee2");
			employeeDao.deleteEmployee(employee2);
			System.out.println("After employee 2?");
		}

//		roleId = role.getRoleId();
//		System.out.println(roleId);
//		if (userRoleDao.readUserRole(roleId)!= null) {
//			userRoleDao.deleteUserRole(role);
//		}

=======
					
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
		
		
	
	
		
		
>>>>>>> 173611f9e293e5b150de55fca0c423d783177c76
	}

	@Test
	public void createTicketTest() {

		Ticket returnedTicket = ticketDao.createTicket(ticket);
		assertEquals(returnedTicket, ticket);
	}

	@Test
	public void deleteTicketTest() {
		Ticket ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(), status, priority1, 3, null,
				employee2);
		ticketDao.createTicket(ticket);
		long ticketId = ticket.getTicketId();
		ticketDao.deleteTicket(ticket);
		assertNull(ticketDao.readTicket(ticketId));

	}

	@Test
	public void createUserRoleTest() {
<<<<<<< HEAD
//		UserRole returnedRole = userRoleDao.createUserRole(role);
//		roleId = returnedRole.getRoleId();
//		assertEquals(returnedRole, role);

=======
		UserRole returnedRole = userRoleDao.createUserRole(createRole);
		//createRoleId = returnedRole.getRoleId();
		assertEquals(returnedRole, createRole);
		
		
>>>>>>> 173611f9e293e5b150de55fca0c423d783177c76
	}

	@Test
	public void readUserRoleTest() {
<<<<<<< HEAD

=======
		UserRole readRole;
		readRole = userRoleDao.readUserRole(1);
		assertEquals(readRole, new UserRole(1, "Basic", 1));
		
>>>>>>> 173611f9e293e5b150de55fca0c423d783177c76
	}

	@Test
<<<<<<< HEAD
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
=======
	public void deleteUserRoleTest() {
		userRoleDao.deleteUserRole(testRole);
		assertNull(userRoleDao.readUserRole(testRoleId1));
	}
	

>>>>>>> 173611f9e293e5b150de55fca0c423d783177c76
}
