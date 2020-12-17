package BugTracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BugTracker.pojos.Ticket;

@Repository(value="ticketDao")

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
		tx.commit();
		sess.close();
		
		
		return ticket;

	}

	@Override
	public Ticket readTicket(long ticketId) { 
		Ticket ticket;
		Session sess = sessionFactory.openSession();
		ticket =  sess.get( Ticket.class, ticketId);
		sess.close();
		return ticket;
		
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(ticket);
		tx.commit();
		sess.close();
		

	}

}
