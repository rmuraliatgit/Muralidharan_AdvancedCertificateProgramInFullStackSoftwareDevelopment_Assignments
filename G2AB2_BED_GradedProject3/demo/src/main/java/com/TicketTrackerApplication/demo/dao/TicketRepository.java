package com.TicketTrackerApplication.demo.dao;

import com.TicketTrackerApplication.demo.entity.Ticket;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	Ticket findByTitle(String title);

	Ticket findByTicketShortDescription(String description);

	Optional<Ticket> findById(Long id);

	@Query("SELECT t FROM Ticket t WHERE t.title like %:searchTerm% OR t.ticketShortDescription like %:searchTerm%")
	List<Ticket> searchTickets(String searchTerm);

}
