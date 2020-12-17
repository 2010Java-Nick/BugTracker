package BugTracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BugTracker.pojos.Priority;
@Repository(value="priorityDao")

public class PriorityDaoImpl implements PriorityDao {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Autowired
	public PriorityDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	/**
	 * createPriority takes in a priority, adds it to the database, then returns that priority
	 * @param priority
	 * @returns	priority
	 * @author Acacia and Hannah
	 */
	
	//TODO testing
	@Override
	public Priority createPriority(Priority priority) {
	
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(priority);
		tx.commit();
		sess.close();
		
		
		return priority;
	}

	
	/**
	 * readPriorityById takes in the priority id, returns the corresponding priority object from
	 * the database
	 * @param long
	 * @returns priority
	 * @author Acacia and Hannah
	 */
	
	//TODO testing
	@Override
	public Priority readPriorityById(long priorityId) {
		Session sess = sessionFactory.openSession();
		Priority priority = sess.get(Priority.class, priorityId);
		sess.close();
		
		return priority;
		
	}

	@Override
	public Priority updatePriority(long priorityId, Priority priority) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePriority(Priority priority) {
		// TODO Auto-generated method stub

	}

}
