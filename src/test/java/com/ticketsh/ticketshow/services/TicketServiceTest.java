package com.ticketsh.ticketshow.services;

import com.ticketsh.ticketshow.entities.Ticket;
import com.ticketsh.ticketshow.entities.TicketStore;
import com.ticketsh.ticketshow.mock.TicketMock;
import com.ticketsh.ticketshow.mock.TicketStoreMock;
import com.ticketsh.ticketshow.repositories.TicketRepository;
import com.ticketsh.ticketshow.repositories.TicketStoreRepository;
import com.ticketsh.ticketshow.services.impl.TicketServiceImpl;
import com.ticketsh.ticketshow.utils.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@SpringBootTest
public class TicketServiceTest {

    public static final long ROW = 1L;
    public static final long SECTION = 1L;
    public static final long SEAT = 1L;
    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private TicketStoreRepository ticketStoreRepository;

    @InjectMocks
    private TicketServiceImpl ticketService;


    @Autowired
    private TicketService service;

    @Mock
    TicketStore ticketStoreMock;


    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testSaveTicketNoTicketAvailable() throws BusinessException {

        given(ticketRepository.registeredTicket()).willReturn(99L);

        TicketStore ticketStore= TicketStoreMock.getTicketStore(ROW,SECTION,SEAT);

        given(ticketStoreRepository
                .findTicketStore(ROW, SECTION, SEAT)).willReturn(ticketStore);

        Ticket ticket=TicketMock.newTicket();

        given(ticketRepository.save(ticket)).willReturn(ticket);

        ticketService.saveTicket(ticket);

        then(ticketRepository).should().save(ticket);

    }


    @Test
    public void testSaveTicketNoTicketAvailable_TicketStore_Updated_Inactive_Evaluate_TicketStore_Status_1() throws BusinessException {

        given(ticketRepository.registeredTicket()).willReturn(99L);

        TicketStore ticketStore= TicketStoreMock.getTicketStore(ROW,SECTION,SEAT);

        given(ticketStoreRepository
                .findTicketStore(ROW, SECTION, SEAT)).willReturn(ticketStoreMock);

        Ticket ticket=TicketMock.newTicket();
        given(ticketStoreMock.getStatus()).willReturn(1L);

        given(ticketRepository.save(ticket)).willReturn(ticket);
        ticketStoreMock.setStatus(2L);
        given(ticketStoreRepository.save(ticketStore)).willReturn(ticketStoreMock);

        ticketService.saveTicket(ticket);

        then(ticketStoreRepository).should().findTicketStore(ROW, SECTION, SEAT);
        then(ticketRepository).should().save(ticket);
        then(ticketStoreRepository).should().save(ticketStoreMock);

    }


    @Test
    public void testSaveTicketNoTicketAvailable_TicketStore_Updated_Inactive_Evaluate_TicketStore_Status_2() throws BusinessException {

        given(ticketRepository.registeredTicket()).willReturn(99L);

        TicketStore ticketStore= TicketStoreMock.getTicketStore(ROW,SECTION,SEAT);

        given(ticketStoreRepository
                .findTicketStore(ROW, SECTION, SEAT)).willReturn(ticketStoreMock);

        Ticket ticket=TicketMock.newTicket();


        given((ticketStoreMock.getStatus())).willReturn(2L);

        given(ticketRepository.save(ticket)).willReturn(ticket);
        ticketStore.setStatus(2L);
        given(ticketStoreRepository.save(ticketStore)).willReturn(ticketStore);

        assertThrows(BusinessException.class, ()-> {
            ticketService.saveTicket(ticket);
        });
        then(ticketStoreRepository).should().findTicketStore(ROW, SECTION, SEAT);


    }


    @Test
    public void testSaveTicketNoTicketAvailable_TicketStore_No_Found(){

        given(ticketRepository.registeredTicket()).willReturn(99L);

        given(ticketStoreRepository
                .findTicketStore(ROW, SECTION, SEAT)).willReturn(null);

        Ticket ticket=TicketMock.newTicket();

        given(ticketRepository.save(ticket)).willReturn(ticket);

        assertThrows(BusinessException.class, ()->{
            ticketService.saveTicket(ticket);
        });



    }


    @Test
    public void testSaveTicketNoTicketNotAvailable() {

        given(ticketRepository.registeredTicket()).willReturn(105L);

        given(ticketRepository.save(TicketMock.newTicket())).willReturn(TicketMock.newTicket());

          assertThrows(BusinessException.class, ()->{
              ticketService.saveTicket(TicketMock.newTicket());
          }) ;



    }

    @Test
    public void testHasTicket() {
        given(ticketRepository.registeredTicket()).willReturn(99L);

        boolean hasTicket=ticketService.hasTicket(TicketMock.newTicket());

        then(ticketRepository).should().registeredTicket();
        assertEquals(true,hasTicket);
    }

    @Test
    public void testHasTicketIntegration() {
        boolean hasTicket=service.hasTicket(TicketMock.newTicket());
        assertEquals(true,hasTicket);

    }

    @Test
    public void testSaveTicket()  {

        try {
            service.saveTicket(TicketMock.newTicket());
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }


    }





}