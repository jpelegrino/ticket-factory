package com.ticketsh.ticketshow.services;

import com.ticketsh.ticketshow.dtos.response.TicketDTO;
import com.ticketsh.ticketshow.entities.Ticket;
import com.ticketsh.ticketshow.utils.BusinessException;

public interface TicketService {
    boolean hasTicket(Ticket ticket);

    TicketDTO saveTicket(Ticket ticket)throws BusinessException;

    TicketDTO getAllTickets();

    TicketDTO findTicketById(Long id);
}

