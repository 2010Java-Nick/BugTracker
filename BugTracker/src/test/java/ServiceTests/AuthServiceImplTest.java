package ServiceTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import BugTracker.dao.EmployeeDaoImpl;
import BugTracker.dtos.CredentialsDTO;
import BugTracker.dtos.CurrentUserDTO;
import BugTracker.pojos.Employee;
import BugTracker.pojos.UserRole;
import BugTracker.services.AuthServiceImpl;
import BugTracker.utils.AuthException;

@RunWith(MockitoJUnitRunner.class)
public class AuthServiceImplTest {
	
	@Mock()
	EmployeeDaoImpl employeeDao;
	
	@InjectMocks
	AuthServiceImpl authService;
	
	Employee employee;
	CredentialsDTO credentials;
	CurrentUserDTO currentUser;
	
	@Before
	public void setUp() throws Exception {
		credentials = new CredentialsDTO("aholliday@gmail.com", "VincentIsSoCool");
		employee = new Employee("Acacia", "Holliday", "aholliday@gmail.com", "VincentIsSoCool", 0, new UserRole("developer", 2));
		when(employeeDao.readEmployeeByCredentials(credentials)).thenReturn(employee);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAuthenticate() throws AuthException {
		currentUser = authService.authenticate(credentials);
		assertEquals(employee.getEmailAddress(), currentUser.getEmail());
	}

}
