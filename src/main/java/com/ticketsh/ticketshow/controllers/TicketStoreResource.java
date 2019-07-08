package com.ticketsh.ticketshow.controllers;

import com.ticketsh.ticketshow.dtos.response.TicketStoreDTO;
import com.ticketsh.ticketshow.dtos.request.TicketStoreRequest;
import com.ticketsh.ticketshow.entities.TicketStore;
import com.ticketsh.ticketshow.services.TicketStoreService;
import com.ticketsh.ticketshow.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("ticketStores")
public class TicketStoreResource {

    @Autowired
    private TicketStoreService ticketStoreService;

    @PostMapping
    public ResponseEntity<Object> saveTicketStore(@Valid @RequestBody  TicketStoreRequest ticketStoreRequest) {
         ticketStoreService.saveTicketStore(ticketStoreRequest.getTicketStores());

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public TicketStoreDTO getAllTicketStore() {
        return ticketStoreService.getAllTicketStore();
    }

    @GetMapping(path = "{id}")
    public TicketStoreDTO getTicketStore(@PathVariable(name = "id",required = true) Long ticketStoreId) {

        TicketStoreDTO ticketStoreDTO= ticketStoreService.findById(ticketStoreId);
        if (!ticketStoreDTO.isSuccessed())
            throw new UserNotFoundException();

        return ticketStoreDTO;

    }







}
