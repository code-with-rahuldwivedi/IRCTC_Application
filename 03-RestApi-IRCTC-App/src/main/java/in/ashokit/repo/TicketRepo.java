package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.bainding.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer>{

}
