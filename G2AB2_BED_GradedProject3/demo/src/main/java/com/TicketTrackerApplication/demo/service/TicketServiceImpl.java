package com.TicketTrackerApplication.demo.service;

import com.TicketTrackerApplication.demo.dao.TicketRepository;
import com.TicketTrackerApplication.demo.entity.Ticket;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Ticket addTicket(Ticket ticket) {

		Ticket newTicket = new Ticket();
		newTicket.setTitle(ticket.getTitle());
		newTicket.setTicketShortDescription(ticket.getTicketShortDescription());
		newTicket.setTicketContent(ticket.getTicketContent());
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String str = formatter.format(date);
		newTicket.setTicketStartDate(str);
		ticketRepository.save(newTicket);
		return newTicket;
	}

	@Override
	public void removeTicket(Long id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public Ticket updateTicket(Long id, Ticket ticket) {

		Optional<Ticket> oldTicket = ticketRepository.findById(id);
		if (!ticket.getTitle().isBlank())
			oldTicket.get().setTitle(ticket.getTitle());
		if (!ticket.getTicketShortDescription().isBlank())
			oldTicket.get().setTicketShortDescription(ticket.getTicketShortDescription());
		if (!ticket.getTicketContent().isBlank())
			oldTicket.get().setTicketContent(ticket.getTicketContent());
		ticketRepository.save(oldTicket.get());
		return oldTicket.get();
	}

	@Override
	public Ticket getTicketByTitle(String title) {
		Ticket foundTicket = ticketRepository.findByTitle(title);
		if (foundTicket != null)
			return foundTicket;
		else
			return null;
	}

	@Override
	public Ticket getTicketByDescription(String description) {
		Ticket foundTicket = ticketRepository.findByTicketShortDescription(description);
		if (foundTicket != null)
			return foundTicket;
		else
			return null;
	}

	@Override
	public Ticket getTicketById(Long id) {
		Optional<Ticket> foundTicket = ticketRepository.findById(id);
		if (foundTicket.get() != null)
			return foundTicket.get();
		else
			return null;
	}

	@Override
	public List<Ticket> getTicketList() {
		List<Ticket> listOfAllTickets = ticketRepository.findAll();
		if (!listOfAllTickets.isEmpty())
			return listOfAllTickets;
		else
			return null;
	}

	@Override
	public List<Ticket> searchResults(String titleOrShortDescription) {
		return ticketRepository.searchTickets(titleOrShortDescription);
	}

}
