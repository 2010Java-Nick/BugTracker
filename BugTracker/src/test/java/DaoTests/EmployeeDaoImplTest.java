package DaoTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import BugTracker.config.AppConfig;
import BugTracker.dao.EmployeeDaoImpl;
import BugTracker.dtos.CredentialsDTO;
import BugTracker.pojos.Employee;
import BugTracker.utils.SessionFactoryUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
public class EmployeeDaoImplTest {

	@Autowired
	public SessionFactoryUtil sessionFactoryUtil;

	@Autowired
	EmployeeDaoImpl employeeDao;

	private Employee employee1;

	@Before
	public void setUp() throws Exception {
		employee1 = new Employee("aholliday@gmail.com", "VincentIsSoCool");
		employeeDao.createEmployee(employee1);

	}

	@After
	public void tearDown() throws Exception {
		long employee1Id = employee1.getEmployeeId();
		System.out.println(employee1Id);
		if (employeeDao.readEmployeeById(employee1Id) != null) {
			employeeDao.deleteEmployee(employee1);
		}
	}

	@Test
	public void testGetEmployeeByCredentials() {
		CredentialsDTO credentials = new CredentialsDTO("aholliday@gmail.com", "VincentIsSoCool");
		Employee e = employeeDao.readEmployeeByCredentials(credentials);
		assertEquals(employee1.getEmailAddress(), e.getEmailAddress());
	}

}
