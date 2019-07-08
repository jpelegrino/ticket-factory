package com.ticketsh.ticketshow.controllers;

import com.ticketsh.ticketshow.dtos.response.EventDTO;
import com.ticketsh.ticketshow.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("events")
public class EventResource {

    @Autowired
    private EventService eventService;

    @GetMapping
    public EventDTO getAllEvent() {
        return eventService.getAllEvent();
    }


}
