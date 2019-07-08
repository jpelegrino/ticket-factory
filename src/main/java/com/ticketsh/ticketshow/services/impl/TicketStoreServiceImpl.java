package com.ticketsh.ticketshow.services.impl;

import com.ticketsh.ticketshow.dtos.response.TicketStoreDTO;
import com.ticketsh.ticketshow.entities.TicketStore;
import com.ticketsh.ticketshow.repositories.TicketStoreRepository;
import com.ticketsh.ticketshow.services.TicketStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketStoreServiceImpl implements TicketStoreService {

    @Autowired
    private TicketStoreRepository ticketStoreRepository;

    @Override
    public TicketStoreDTO saveTicketStore(List<TicketStore> ticketStoreList) {
        TicketStoreDTO ticketStoreDTO=new TicketStoreDTO();
        List<TicketStore> ticketStores=ticketStoreRepository.saveAll(ticketStoreList);
        ticketStoreDTO.setSuccessed(!ticketStoreList.isEmpty());
        ticketStoreDTO.setTicketStoreList(ticketStores);

        return ticketStoreDTO;
    }

    @Override
    public TicketStoreDTO getAllTicketStore() {
        TicketStoreDTO ticketStoreDTO=new TicketStoreDTO();
        List<TicketStore> ticketStores= ticketStoreRepository.findAll();
        ticketStoreDTO.setTicketStoreList(ticketStores);
        ticketStoreDTO.setSuccessed(!ticketStores.isEmpty());

        return ticketStoreDTO;

    }

    @Override
    public TicketStoreDTO findById(Long id) {
        TicketStoreDTO ticketStoreDTO=new TicketStoreDTO();
        Optional<TicketStore> ticketStore=ticketStoreRepository.findById(id);
        boolean success=ticketStore.isPresent();
        if(success)
        ticketStoreDTO.setTicketStore(ticketStore.get());

        ticketStoreDTO.setSuccessed(success);

        return ticketStoreDTO;

    }
}
