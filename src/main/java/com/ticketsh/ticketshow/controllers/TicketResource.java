package com.ticketsh.ticketshow.controllers;

import com.ticketsh.ticketshow.dtos.response.TicketDTO;
import com.ticketsh.ticketshow.entities.Ticket;
import com.ticketsh.ticketshow.services.TicketService;
import com.ticketsh.ticketshow.utils.BusinessException;
import com.ticketsh.ticketshow.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("tickets")
public class TicketResource {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity saveTicket(@Valid @RequestBody Ticket ticket) {
        TicketDTO ticketDTO=new TicketDTO();
        URI location=null;
        try {
            ticketDTO=ticketService.saveTicket(ticket);
            location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(ticketDTO.getTicket().getId()).toUri();

        } catch (BusinessException e) {
            ticketDTO.setErrorMessage(e.getMessage());
        }

        if (!ticketDTO.isSuccessed())
            return ResponseEntity.notFound().build();



        return ResponseEntity.created(location).build();

    }

    @GetMapping
    public TicketDTO getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping(path = "{id}")
    public TicketDTO findTicketById(@PathVariable(name = "id") Long ticketId) {
       TicketDTO ticketDTO= ticketService.findTicketById(ticketId);
       if(!ticketDTO.isSuccessed())
           throw new  UserNotFoundException();
        return ticketDTO;
    }


}
