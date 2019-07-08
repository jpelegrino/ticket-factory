package com.ticketsh.ticketshow.services;

import com.ticketsh.ticketshow.dtos.response.TicketStoreDTO;
import com.ticketsh.ticketshow.entities.TicketStore;

import java.util.List;

public interface TicketStoreService {
    TicketStoreDTO saveTicketStore(List<TicketStore> ticketStoreList);

    TicketStoreDTO getAllTicketStore();

    TicketStoreDTO findById(Long id);
}


