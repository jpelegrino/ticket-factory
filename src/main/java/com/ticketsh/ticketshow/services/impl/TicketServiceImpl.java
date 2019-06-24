package com.ticketsh.ticketshow.services.impl;

import com.ticketsh.ticketshow.entities.Ticket;
import com.ticketsh.ticketshow.entities.TicketStore;
import com.ticketsh.ticketshow.repositories.TicketRepository;
import com.ticketsh.ticketshow.repositories.TicketStoreRepository;
import com.ticketsh.ticketshow.services.TicketService;
import com.ticketsh.ticketshow.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketStoreRepository ticketStoreRepository;

    @Override
    public boolean hasTicket(Ticket ticket) {
        try {
            Long registeredTiket = ticketRepository.registeredTicket();

            if (registeredTiket < ticket.getEvent().getSeatQuantity())
                return true;
            return false;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public void saveTicket(Ticket ticket) throws BusinessException {

        if(!hasTicket(ticket))
            throw new BusinessException("No more ticket available");

            TicketStore tk=ticket.getTicketStore();
            TicketStore ticketStore=ticketStoreRepository.findTicketStore(tk.getRowNumber(),tk.getSection(),tk.getSeatNumber());
            if(Objects.isNull(ticketStore))
                throw new BusinessException("This ticket not found");

            if(ticketStore.getStatus()!=1)
                throw new BusinessException("This ticket has been taken");

            ticketRepository.save(ticket);

            ticketStoreRepository.save(ticketStore);

    }
}
