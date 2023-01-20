package com.TicketTrackerApplication.demo.service;

import com.TicketTrackerApplication.demo.entity.Ticket;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface TicketService {

	public Ticket addTicket(Ticket ticket);

	public void removeTicket(Long id);

	public Ticket updateTicket(Long id, Ticket ticket);

	public Ticket getTicketByTitle(String title);

	public Ticket getTicketByDescription(String description);

	public Ticket getTicketById(Long id);

	public List<Ticket> getTicketList();

	public List<Ticket> searchResults(String titleOrShortDescription);

}
