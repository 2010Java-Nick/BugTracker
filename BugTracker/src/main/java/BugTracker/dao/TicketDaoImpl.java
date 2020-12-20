package BugTracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BugTracker.dtos.TicketDto;
import BugTracker.pojos.Employee;
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
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(ticket);
		tx.commit();
		sess.close();
		
		return ticket;
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(ticket);
		tx.commit();
		sess.close();
		

	}

	/**
	 * this method takes in an employee id and returns all tickets in the database that were opened
	 * by that employee
	 * 
	 * @param long
	 * @returns List<Ticket>
	 * @author Acacia and Hannah
	 */
	@Override
	public List<Ticket> readTicketsByOpener(long openerId) {
		Session sess = sessionFactory.openSession();
		List<Ticket> ticketList = sess.createQuery("from Ticket where opener_id = :id", Ticket.class)
				.setParameter("id", openerId).getResultList();
		return ticketList;
	}

	/**
	 * this method takes in an employee id and returns all tickets in the database that were assigned
	 * to that employee
	 * 
	 * @param long
	 * @returns List<Ticket>
	 * @author Acacia and Hannah
	 */
	@Override
	public List<Ticket> readTicketsByAssignedId(long assignedId) {
		Session sess = sessionFactory.openSession();
		List<Ticket> ticketList = sess.createQuery("from Ticket where employee_id = :id", Ticket.class)
				.setParameter("id", assignedId).getResultList();
		return ticketList;
	}

	@Override
	public List<Ticket> getAllTickets() {
		Session sess = sessionFactory.openSession();
		List<Ticket> ticketList = sess.createQuery("from Ticket", Ticket.class).getResultList();
		return ticketList;
	}

	@Override
	public List<TicketDto> getAllTicketsDto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
