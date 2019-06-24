package com.ticketsh.ticketshow.mock;

import com.ticketsh.ticketshow.entities.Event;

import java.util.Date;

public class EventMock {


    public static final Date EVENT_DATE = new Date();
    public static final String EVENT_NAME = "Event 1";
    public static final long SEAT_QUANTITY = 100L;
    public static final String LOCATION = "Estadio Olympico";

    public static Event newEvent() {
        return new Event(EVENT_DATE, EVENT_NAME, SEAT_QUANTITY, LOCATION);
    }
}
