package com.ticketsh.ticketshow.integration;

import com.ticketsh.ticketshow.entities.Event;
import com.ticketsh.ticketshow.services.EventService;
import com.ticketsh.ticketshow.mock.EventMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EventServiceIntegratonTest {

    @Autowired
    private EventService eventService;


    @Test
    public void testSaveEvent() {
        Event event=eventService.saveEvent(EventMock.newEvent());

        assertNotNull(event);
        assertNotNull(event.getId());
    }


}
