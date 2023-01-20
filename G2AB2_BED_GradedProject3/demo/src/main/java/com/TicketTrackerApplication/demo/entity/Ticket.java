package com.TicketTrackerApplication.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TicketId")
	private Long id;

	@Column(name = "Title")
	private String title;

	@Column(name = "ShortDescription")
	private String ticketShortDescription;

	@Column(name = "CreatedOn")
	private String ticketStartDate;

	@Column(name = "Content")
	private String ticketContent;

	public Ticket() {
	}

	public Ticket(Long id, String title, String ticketShortDescription, String ticketStartDate, String ticketContent) {
		super();
		this.id = id;
		this.title = title;
		this.ticketShortDescription = ticketShortDescription;
		this.ticketStartDate = ticketStartDate;
		this.ticketContent = ticketContent;
	}

	public Ticket(String title, String ticketShortDescription, String ticketStartDate, String ticketContent) {
		super();
		this.title = title;
		this.ticketShortDescription = ticketShortDescription;
		this.ticketStartDate = ticketStartDate;
		this.ticketContent = ticketContent;
	}

	public String getTicketShortDescription() {
		return ticketShortDescription;
	}

	public void setTicketShortDescription(String ticketShortDescription) {
		this.ticketShortDescription = ticketShortDescription;
	}

	public String getTicketStartDate() {
		return ticketStartDate;
	}

	public void setTicketStartDate(String ticketStartDate) {
		this.ticketStartDate = ticketStartDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketContent() {
		return ticketContent;
	}

	public void setTicketContent(String ticketContent) {
		this.ticketContent = ticketContent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Ticket{" + "id=" + id + ", ticketTitle='" + title + '\'' + ", ticketShortDescription='"
				+ ticketShortDescription + '\'' + ", ticketStartDate=" + ticketStartDate + '}';
	}
}
