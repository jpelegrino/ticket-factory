package com.ticketsh.ticketshow.dtos.response;

import com.ticketsh.ticketshow.entities.Event;

import java.util.List;

public class EventDTO {

    private Event event;
    private List<Event> events;
    private boolean successed;
    private String errorMessage;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
