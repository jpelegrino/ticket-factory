package com.ticketsh.ticketshow.mock;

import com.ticketsh.ticketshow.entities.Event;
import com.ticketsh.ticketshow.entities.Status;
import com.ticketsh.ticketshow.entities.Ticket;
import com.ticketsh.ticketshow.entities.TicketStore;
import com.ticketsh.ticketshow.enums.StatusEnum;

public class TicketMock {

    public static Ticket newTicket() {
        Ticket ticket=new Ticket();
        Event event=EventMock.newEvent();
        event.setId(1L);

        Status status=new Status();
        status.setId(StatusEnum.ACTIVE.getStatus());

        ticket.setEvent(event);
        TicketStore ticketStore=new TicketStore(1L,1L,1L, status);
        ticket.setTicketStore(ticketStore);

        return ticket;
    }



}
