package in.ashokit.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bainding.Passenger;
import in.ashokit.bainding.Ticket;
import in.ashokit.repo.TicketRepo;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepo ticketRepo;
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket t =new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketStatus("CONFIRMED");
		Ticket saveTicket = ticketRepo.save(t);
		return saveTicket;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		return ticketRepo.findById(ticketId).orElseThrow();
	}

	@Override
	public List<Ticket> getTickets() {
		return ticketRepo.findAll();
	}
	
	@Override
    public Ticket cancelTicket(Integer ticketId) {
        // Retrieve the ticket from the repository
        Ticket ticket = ticketRepo.findById(ticketId)
                                  .orElseThrow(() -> new IllegalArgumentException("Ticket not found"));

        // Set ticket status to CANCELLED
        ticket.setTicketStatus("CANCELLED");

        // Save the updated ticket
        return ticketRepo.save(ticket);
    }
}
