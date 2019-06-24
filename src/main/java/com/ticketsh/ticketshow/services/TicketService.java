package com.ticketsh.ticketshow.services;

import com.ticketsh.ticketshow.entities.Ticket;
import com.ticketsh.ticketshow.utils.BusinessException;

public interface TicketService {
    boolean hasTicket(Ticket ticket);

    void saveTicket(Ticket ticket)throws BusinessException;
}
