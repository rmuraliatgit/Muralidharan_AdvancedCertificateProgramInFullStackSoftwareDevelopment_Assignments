package com.TicketTrackerApplication.demo.controller;

import com.TicketTrackerApplication.demo.dao.TicketRepository;
import com.TicketTrackerApplication.demo.entity.Ticket;
import com.TicketTrackerApplication.demo.service.TicketService;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
@RequestMapping("/admin/tickets")
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping("")
	public String listTickets(Model model) {
		List<Ticket> tickets = ticketService.getTicketList();
		model.addAttribute("tickets", tickets);
		return "list";
	}

	@GetMapping("/newTicket")
	public String newTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "create-ticket";
	}

	@PostMapping("")
	public String newTicket(Ticket ticket) {
		ticketService.addTicket(ticket);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/{id}/edit")
	public String updateTicketForm(@PathVariable Long id, Model model) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		model.addAttribute("ticket", ticket.get());
		return "edit";
	}

	@PostMapping("/{id}")
	public String updateTicket(@PathVariable Long id, Ticket ticket) {
		ticketService.updateTicket(id, ticket);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		ticketService.removeTicket(id);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/{id}/view")
	public String view(@PathVariable Long id, Model model) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		model.addAttribute("ticket", ticket.get());
		return "view";
	}

	@GetMapping("/search")
	public String searchResults(@RequestParam("query") String titleOrShortDescription, Model model) {
		List<Ticket> tickets = ticketService.searchResults(titleOrShortDescription);
		model.addAttribute("tickets", tickets);
		return "list";
	}
}
