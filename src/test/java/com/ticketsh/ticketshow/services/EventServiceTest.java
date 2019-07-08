package com.ticketsh.ticketshow.services;

import com.ticketsh.ticketshow.dtos.response.EventDTO;
import com.ticketsh.ticketshow.entities.Event;
import com.ticketsh.ticketshow.repositories.EventRepository;
import com.ticketsh.ticketshow.services.impl.EventServiceImpl;
import com.ticketsh.ticketshow.mock.EventMock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@SpringBootTest
public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;
    @InjectMocks
    private EventServiceImpl eventService;
    @Autowired
    private EventService service;


    @BeforeEach
    public void setUp() {
    }


    @Test
    public void testSaveEvent() {
        //given
        Event event=EventMock.newEvent();
        Event eventSaved=event;

        given(eventRepository.save(event)).willReturn(eventSaved);
        //when
        EventDTO eventPersist=eventService.saveEvent(event);
        //then
        then(eventRepository).should().save(event);
        assertNotNull(eventPersist);


    }

    @Test
    public void testGetAllEvent() {
        List<Event> events= Arrays.asList(new Event());

        given(eventRepository.findAll()).willReturn(events);

        EventDTO eventDTO=eventService.getAllEvent();

        then(eventRepository).should().findAll();
        assertTrue(eventDTO.isSuccessed());

    }


    @Test
    public void testIntegrationSaveEvent() {
        EventDTO event=service.saveEvent(EventMock.newEvent());

        assertNotNull(event);
        assertNotNull(event.getEvent());
    }


}