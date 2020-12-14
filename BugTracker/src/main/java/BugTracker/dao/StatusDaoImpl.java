package BugTracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BugTracker.pojos.Employee;
import BugTracker.pojos.Status;
@Repository(value= "statusDao")
public class StatusDaoImpl implements StatusDao {
	

	SessionFactory sessionFactory;

	
	
	@Autowired
	public StatusDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * createStatus takes in a status object, adds it to the database, then returns the added object
	 * @param Status
	 * @returns Status
	 * @author Acacia and Hannah
	 */
	//TODO testing
	@Override
	public Status createStatus(Status status) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(status);
		tx.commit();
		sess.close();
		
		
		return status;
	}

	/**
	 * readStatusById takes in the status ID as a long, returns from the database the corresponding object
	 * @param long
	 * @returns Status
	 * @author Acacia and Hannah
	 */
	//TODO testing
	@Override
	public Status readStatusById(long statusId) {
		Status status;
		Session sess = sessionFactory.openSession();
		status =  sess.get( Status.class, statusId);
		sess.close();
		return status;
	}

	@Override
	public Status updateStatus(long StatusId, Status status) {
		return null;
	}

	@Override
	public void deleteStatus(Status status) {
		// TODO Auto-generated method stub

	}

}
