package BugTracker.dao;

import java.util.List;

import BugTracker.dtos.TicketDto;
import BugTracker.pojos.Ticket;

/**
 * This is the interface for the basic CRUD methods for the ticket table in the database.
 * @author Vincent
 *
 */


public interface TicketDao {
	
	public Ticket createTicket(Ticket ticket);
	
	public Ticket readTicket(long ticketId);
	
	public Ticket updateTicket(Ticket ticket);
	
	public void deleteTicket(Ticket ticket);
	
	public List<Ticket>getAllTickets();
	
	public List<Ticket> readTicketsByOpener(long openerId);
	
	public List<Ticket> readTicketsByAssignedId(long assignedId);
	
	public List<TicketDto>getAllTicketsDto();
	
}
