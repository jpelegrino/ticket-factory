package com.ticketsh.ticketshow.services;

import com.ticketsh.ticketshow.entities.TicketStore;
import com.ticketsh.ticketshow.mock.TicketStoreMock;
import com.ticketsh.ticketshow.repositories.TicketStoreRepository;
import com.ticketsh.ticketshow.services.impl.TicketStoreServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@SpringBootTest
public class TicketStoreServiceTest {

    @Mock
    private TicketStoreRepository ticketStoreRepository;

    @InjectMocks
    private TicketStoreServiceImpl ticketStoreService;

    @Autowired
    private TicketStoreService service;


    @Test
    public void testSaveTicketStore() {
        Long row=3L,col=5L;
        Long times=row*col;
        List<TicketStore> ticketStoreList=TicketStoreMock.generateTicket(row,col);
        given(ticketStoreRepository.saveAll(ticketStoreList)).willReturn(ticketStoreList);

        ticketStoreService.saveTicketStore(ticketStoreList);

        then(ticketStoreRepository).should().saveAll(ticketStoreList);


    }

}