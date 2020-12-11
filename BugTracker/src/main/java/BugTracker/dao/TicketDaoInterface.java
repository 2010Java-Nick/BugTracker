package BugTracker.dao;

import BugTracker.pojos.Ticket;

/**
 * This is the interface for the basic CRUD methods for the ticket table in the database.
 * @author Vincent
 *
 */


public interface TicketDaoInterface {
	
	public void createTicket(Ticket ticket);
	
	public Ticket readTicket(long ticketId);
	
	public Ticket updateTicket(long ticketId, Ticket ticket);
	
	public void deleteTicket(Ticket ticket);

}
