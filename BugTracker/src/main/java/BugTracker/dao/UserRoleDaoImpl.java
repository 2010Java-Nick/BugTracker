package BugTracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import BugTracker.pojos.UserRole;

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
	
	//TODO test createUserRole
	@Override
	public UserRole createUserRole(UserRole userRole) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(userRole);
		tx.commit();
		sess.close();
		
		
		return userRole;
	}

	@Override
	public UserRole readUserRole(long userRoleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole updateUserRole(long userRoleId, UserRole userRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		
	}

}
