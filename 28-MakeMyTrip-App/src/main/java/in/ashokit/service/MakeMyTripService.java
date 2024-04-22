
package in.ashokit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.bainding.Passenger;
import in.ashokit.bainding.Ticket;
import reactor.core.publisher.Mono;

@Service
public class MakeMyTripService {

	private final String BOOK_TICKET_URL = "http://localhost:9090/ticket";
	
	private final String GET_TICKETS_URL = "http://localhost:9090/tickets";

	 private final String CANCEL_TICKET_URL = "http://localhost:9090/cancelTicket";
	
	public Mono<Ticket> bookTicket(Passenger p) {
		WebClient webClient = WebClient.create();		
		return webClient.post()
						 .uri(BOOK_TICKET_URL)
						 .body(BodyInserters.fromValue(p))
						 .retrieve()
						 .bodyToMono(Ticket.class);

	}

	public Mono<Ticket[]> getAllTickets() {
		WebClient webClient = WebClient.create();	
		return webClient.get()
						 .uri(GET_TICKETS_URL)
						 .retrieve()
						 .bodyToMono(Ticket[].class);
	}
	
	 public Mono<Void> cancelTicket(Integer ticketId) {
	        WebClient webClient = WebClient.create();
	        return webClient.delete()
	                .uri(CANCEL_TICKET_URL + "/" + ticketId)
	                .retrieve()
	                .bodyToMono(Void.class);
	    }
}
