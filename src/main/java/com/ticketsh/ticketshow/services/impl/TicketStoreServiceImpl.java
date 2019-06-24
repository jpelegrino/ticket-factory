package com.ticketsh.ticketshow.services.impl;

import com.ticketsh.ticketshow.entities.TicketStore;
import com.ticketsh.ticketshow.repositories.TicketStoreRepository;
import com.ticketsh.ticketshow.services.TicketStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketStoreServiceImpl implements TicketStoreService {

    @Autowired
    private TicketStoreRepository ticketStoreRepository;

    @Override
    public void saveTicketStore(List<TicketStore> ticketStoreList) {
        ticketStoreRepository.saveAll(ticketStoreList);
    }
}
