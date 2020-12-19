package BugTracker.services;

import java.util.List;

import BugTracker.dtos.TicketDto;
import BugTracker.pojos.Priority;
import BugTracker.pojos.Ticket;

public interface TicketService {
	
	public Ticket getTicket(long ticketId);
	
	public List<Ticket> getAllTickets();
	
	public List<Ticket> getAllTicketsByOpener(long employeeId);
	
	public List<Ticket> getAllTicketsByAssigned(long employeeId);
	
	public Ticket createTicket(TicketDto ticketDto);
	
	public Ticket updateTicket(Ticket ticket);
	
	public void deleteTicket(Ticket ticket);
	
	public Priority getPriorityObject(long priorityId);
	
	
	
}
