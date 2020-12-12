package BugTracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import BugTracker.pojos.Ticket;

public class TicketDaoImpl implements TicketDao {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Autowired
	public TicketDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * createTicket takes in a new ticket, 
	 * adds it to the database, and returns the added ticket
	 * @params ticket
	 * @returns ticket
	 */
	@Override
	public Ticket createTicket(Ticket ticket) {
		
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(ticket);
		sess.close();
		
		return ticket;

	}

	@Override
	public Ticket readTicket(long ticketId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket updateTicket(long ticketId, Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		// TODO Auto-generated method stub

	}

}
