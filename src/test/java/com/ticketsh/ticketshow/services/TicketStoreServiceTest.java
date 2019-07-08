package com.ticketsh.ticketshow.services;

import com.ticketsh.ticketshow.dtos.response.TicketStoreDTO;
import com.ticketsh.ticketshow.entities.TicketStore;
import com.ticketsh.ticketshow.mock.TicketStoreMock;
import com.ticketsh.ticketshow.repositories.TicketStoreRepository;
import com.ticketsh.ticketshow.services.impl.TicketStoreServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@SpringBootTest
public class TicketStoreServiceTest {

    private static final Long ID = 1L;
    @Mock
    private TicketStoreRepository ticketStoreRepository;

    @InjectMocks
    private TicketStoreServiceImpl ticketStoreService;

    @Autowired
    private TicketStoreService service;


    @Test
    public void testSaveTicketStore() {
        Long row=3L,col=5L;
        List<TicketStore> ticketStoreList=TicketStoreMock.generateTicket(row,col);
        given(ticketStoreRepository.saveAll(ticketStoreList)).willReturn(ticketStoreList);

        TicketStoreDTO ticketStoreDTO=ticketStoreService.saveTicketStore(ticketStoreList);

        then(ticketStoreRepository).should().saveAll(ticketStoreList);
        assertNotNull(ticketStoreDTO);
        assertTrue(ticketStoreDTO.isSuccessed());


    }


    @Test
    public void testFindAllTicketStore() {
        List<TicketStore> ticketStores= Arrays.asList(new TicketStore(),new TicketStore());

        given(ticketStoreRepository.findAll()).willReturn(ticketStores);
       TicketStoreDTO ticketStoreDTO=ticketStoreService.getAllTicketStore();

        then(ticketStoreRepository).should().findAll();
        assertTrue(ticketStoreDTO.isSuccessed());



    }


    @Test
    public void testFindTicketStoreById() {
        TicketStore ticketStore=new TicketStore();

        Optional<TicketStore> ticketStoreOptional=Optional.of((TicketStore) ticketStore);
        given(ticketStoreRepository.findById(ID)).willReturn(ticketStoreOptional);

        TicketStoreDTO store=ticketStoreService.findById(ID);

        then(ticketStoreRepository).should().findById(ID);
        assertNotNull(store);
    }

}