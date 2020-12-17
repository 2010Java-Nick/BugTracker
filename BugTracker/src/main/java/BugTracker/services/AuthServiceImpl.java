package BugTracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import BugTracker.dao.EmployeeDao;
import BugTracker.dtos.CredentialsDTO;
import BugTracker.dtos.CurrentUserDTO;
import BugTracker.pojos.Employee;
import BugTracker.utils.AuthException;

@Service
public class AuthServiceImpl implements AuthService {

	private EmployeeDao empDao;
	
	@Autowired
	@Qualifier(value = "EmployeeDao")
	public void setEmployeeDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	
	@Override
	public CurrentUserDTO authenticate(CredentialsDTO credentials) throws AuthException {
		Employee employee = empDao.readEmployeeByCredentials(credentials);
		if (employee == null) {
			throw new AuthException("Credentials did not match any employee");
		}
		else  {
			return new CurrentUserDTO(employee);
		}
	}

}
