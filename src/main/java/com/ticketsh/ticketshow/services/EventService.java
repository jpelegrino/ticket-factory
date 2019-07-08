package com.ticketsh.ticketshow.services;

import com.ticketsh.ticketshow.dtos.response.EventDTO;
import com.ticketsh.ticketshow.entities.Event;

public interface EventService {
    EventDTO saveEvent(Event event);

    EventDTO getAllEvent();
}
