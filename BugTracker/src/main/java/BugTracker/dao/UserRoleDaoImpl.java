package BugTracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BugTracker.pojos.Status;
import BugTracker.pojos.UserRole;

@Repository(value="userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {
	
	SessionFactory sessionFactory;

	
	
	@Autowired
	public UserRoleDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * createUserRole takes in userRole object, adds to database, returns added object
	 * @param UserRole
	 * @returns UserRole
	 * @author Acacia and Hannah
	 */
	
	//TODO test createUserRole in DAO
	@Override
	public UserRole createUserRole(UserRole userRole) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(userRole);
		tx.commit();
		sess.close();
		
		
		return userRole;
	}

	/**
	 * readUserRole takes in a role ID, returns the corresponding object from the database
	 * @param long
	 * @returns UserRole
	 * @author Acacia and Hannah
	 */
	//TODO testing for readUserRole in DAO
	@Override
	public UserRole readUserRole(long userRoleId) {
		UserRole userRole;
		Session sess = sessionFactory.openSession();
		userRole =  sess.get(UserRole.class, userRoleId);
		sess.close();
		return userRole;
	}
	
	@Override
	public void deleteUserRole(UserRole userRole) {
		
	Session sess = sessionFactory.openSession();
	Transaction tx = sess.beginTransaction();
	sess.delete(userRole);
	tx.commit();
	sess.close();
		
	}

}
