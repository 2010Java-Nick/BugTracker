package BugTracker.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BugTracker.dtos.CredentialsDTO;
import BugTracker.pojos.Employee;

@Repository(value = "employeeDao")
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
	 * createEmployee takes in a new employee object, adds it to the database, then
	 * returns the added object
	 * 
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
		employee = sess.get(Employee.class, employeeId);
		sess.close();
		return employee;

	}

	@Override
	public Employee readEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee readEmployeeByCredentials(CredentialsDTO credentials) {
		Session sess = sessionFactory.openSession();
		Employee employee = sess
				.createQuery("from Employee where email_address = :em and " + "employee_password = :pw", Employee.class)
				.setParameter("em", credentials.getEmail()).setParameter("pw", credentials.getPassword())
				.getSingleResult();
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(employee);
		tx.commit();
		sess.close();
		return employee;
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
	public Employee findAssigned(long employeeId) {
		Session sess = sessionFactory.openSession();

		Query query = sess.createQuery("from Employee where not (employee_id = :em) order by num_tickets")
				.setParameter("em", employeeId).setMaxResults(1);

		Employee employee = (Employee) query.getSingleResult();

		return employee;
	}

	/**
	 * Get the result List of the Top 5 employees with the most experience points
	 * and insert them to a list for the service to unpack and prep it for the user
	 * to view.
	 */
	@Override
	public List<Employee> orderEmployeeByExperience() {
		Session sess = sessionFactory.openSession();
		Query query = sess.createQuery("from Employee e order by e.expPoints DESC").setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>) query.getResultList();
		return employees;
	}

}
