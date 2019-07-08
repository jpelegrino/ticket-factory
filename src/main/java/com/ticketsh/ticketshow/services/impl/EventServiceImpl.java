package com.ticketsh.ticketshow.services.impl;

import com.ticketsh.ticketshow.dtos.response.EventDTO;
import com.ticketsh.ticketshow.entities.Event;
import com.ticketsh.ticketshow.repositories.EventRepository;
import com.ticketsh.ticketshow.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventDTO saveEvent(Event event) {
        EventDTO dto=new EventDTO();
        Event eventSaved= eventRepository.save(event);
        dto.setEvent(eventSaved);

        return dto;
    }

    @Override
    public EventDTO getAllEvent() {
        EventDTO eventDTO=new EventDTO();
        List<Event> events=eventRepository.findAll();
        eventDTO.setEvents(events);
        eventDTO.setSuccessed(Objects.nonNull(events));
        return eventDTO;
    }
}
