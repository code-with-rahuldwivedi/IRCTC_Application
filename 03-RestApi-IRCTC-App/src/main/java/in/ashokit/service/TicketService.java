package in.ashokit.service;

import java.util.List;

import in.ashokit.bainding.Passenger;
import in.ashokit.bainding.Ticket;

public interface TicketService {

	public Ticket bookTicket(Passenger passenger);

	public Ticket getTicket(Integer ticketId);
	
	public List<Ticket> getTickets();
	
	// Method to cancel a ticket
    public Ticket cancelTicket(Integer ticketId);
}
