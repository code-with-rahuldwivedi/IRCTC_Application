package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bainding.Passenger;
import in.ashokit.bainding.Ticket;
import in.ashokit.service.TicketService;

@RestController
public class TicketRestController {
	@Autowired
	private TicketService service;
	@PostMapping(
			value = "/ticket",
			consumes = "application/json",
			produces = "application/json"
	)
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger p){
		Ticket bookTicket = service.bookTicket(p);
		return new ResponseEntity<>(bookTicket, HttpStatus.CREATED);
	}
	@GetMapping(
			value = "ticket/{tid}",
			produces = "application/json"
	)
	public ResponseEntity<Ticket> getTicket(@PathVariable ("tid") Integer tid){
		Ticket ticket = service.getTicket(tid);
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
	
	@GetMapping(
			value ="/tickets",
			produces = "application/json"
	)
	public ResponseEntity<List<Ticket>> getAllTicket(){
		List<Ticket> tickets = service.getTickets();
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}
	
	@DeleteMapping("/cancelTicket/{ticketId}")
    public ResponseEntity<String> cancelTicket(@PathVariable Integer ticketId) {
        Ticket cancelledTicket = service.cancelTicket(ticketId);
        if (cancelledTicket != null) {
            return ResponseEntity.ok().body("Ticket with ID " + ticketId + " has been cancelled.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket with ID " + ticketId + " not found.");
        }
    }
}
