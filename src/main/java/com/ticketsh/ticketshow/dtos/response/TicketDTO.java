package com.ticketsh.ticketshow.dtos.response;

import com.ticketsh.ticketshow.entities.Ticket;

import java.util.List;

public class TicketDTO {

    private Ticket ticket;
    private List<Ticket> tickets;
    private boolean successed;
    private String errorMessage;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
