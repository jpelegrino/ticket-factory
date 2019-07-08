package com.ticketsh.ticketshow.dtos.request;

import com.ticketsh.ticketshow.entities.TicketStore;

import java.util.List;

public class TicketStoreRequest {

    private List<TicketStore> ticketStores;

    public List<TicketStore> getTicketStores() {
        return ticketStores;
    }

    public void setTicketStores(List<TicketStore> ticketStores) {
        this.ticketStores = ticketStores;
    }
}
