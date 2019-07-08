package com.ticketsh.ticketshow.services.impl;

import com.ticketsh.ticketshow.dtos.response.TicketDTO;
import com.ticketsh.ticketshow.entities.Status;
import com.ticketsh.ticketshow.entities.Ticket;
import com.ticketsh.ticketshow.entities.TicketStore;
import com.ticketsh.ticketshow.enums.MessageEnum;
import com.ticketsh.ticketshow.enums.StatusEnum;
import com.ticketsh.ticketshow.repositories.TicketRepository;
import com.ticketsh.ticketshow.repositories.TicketStoreRepository;
import com.ticketsh.ticketshow.services.TicketService;
import com.ticketsh.ticketshow.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
            return true;
        }
    }

    @Override
    public TicketDTO saveTicket(Ticket ticket) throws BusinessException {

        TicketDTO dto=new TicketDTO();

        if(Objects.isNull(ticket.getEvent()))
            throw new BusinessException(MessageEnum.NO_EVENT_ASSOCIATED.getMessage());

        if(!hasTicket(ticket))
            throw new BusinessException(MessageEnum.NO_MORE_TICKET_AVAILABLE.getMessage());

            TicketStore tk=ticket.getTicketStore();
            TicketStore ticketStore=ticketStoreRepository.findTicketStore(tk.getRowNumber(),tk.getSection(),tk.getSeatNumber());
            if(Objects.isNull(ticketStore))
                throw new BusinessException(MessageEnum.THIS_TICKET_NOT_FOUND.getMessage());

            if(ticketStore.getStatus().getId()!= StatusEnum.ACTIVE.getStatus())
                throw new BusinessException(MessageEnum.THIS_TICKET_HAS_BEEN_TAKEN.getMessage());

             Ticket ticketSaved= ticketRepository.save(ticket);
             dto.setTicket(ticketSaved);
             dto.setSuccessed(Objects.nonNull(ticketSaved));

            Status status=new Status();
            status.setId(StatusEnum.INACTIVE.getStatus());

            ticketStore.setStatus(status);
            ticketStoreRepository.save(ticketStore);

            return dto;

    }

    @Override
    public TicketDTO getAllTickets() {
        TicketDTO ticketDTO=new TicketDTO();
        List<Ticket> tickets=ticketRepository.findAll();
        ticketDTO.setTickets(tickets);
        ticketDTO.setSuccessed(Objects.nonNull(tickets));
        return ticketDTO;
    }

    @Override
    public TicketDTO findTicketById(Long id) {
        TicketDTO ticketDTO=new TicketDTO();
        Optional<Ticket> ticket=ticketRepository.findById(id);
        boolean success=ticket.isPresent();
        if(success)
        ticketDTO.setTicket(ticket.get());

        ticketDTO.setSuccessed(success);
        return ticketDTO;
    }
}
