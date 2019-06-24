package com.ticketsh.ticketshow.services.impl;

import com.ticketsh.ticketshow.entities.Event;
import com.ticketsh.ticketshow.repositories.EventRepository;
import com.ticketsh.ticketshow.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}
