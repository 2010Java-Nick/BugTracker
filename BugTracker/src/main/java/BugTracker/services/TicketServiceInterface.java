package BugTracker.services;

import BugTracker.pojos.Ticket;

public interface TicketServiceInterface {
	/**
	 * 
	 * @param ticket
	 * take the ticket object and send to the dao to process it to the database.
	 */
	public void createTicket(Ticket ticket);
	
	//public List<Ticket> getAllEmployeeTickets(long employeeId, ???);  need to know if opener or Assigned developer role to view tickets.
	
	
}
