package BugTracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BugTracker.pojos.Employee;
import BugTracker.pojos.Ticket;

@Repository(value="employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	SessionFactory sessionFactory;

	
	
	@Autowired
	public EmployeeDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	/**
	 * createEmployee takes in a new employee object, adds it to the database, then returns the
	 * added object
	 * @param Employee
	 * @returns Employee
	 * @author Acacia and Hannah
	 */
	
	@Override
	public Employee createEmployee(Employee employee) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(employee);
		tx.commit();
		sess.close();
		
		
		return employee;
	}

	@Override
	public Employee readEmployeeById(long employeeId) {
		Employee employee;
		Session sess = sessionFactory.openSession();
		employee =  sess.get( Employee.class, employeeId);
		sess.close();
		return employee;
	
	}

	@Override
	public Employee readEmployeeByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(long employeeId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(employee);
		tx.commit();
		sess.close();
		
	}

	@Override
	public Employee findAssigned() {
		// TODO Auto-generated method stub
		return null;
	}

}
