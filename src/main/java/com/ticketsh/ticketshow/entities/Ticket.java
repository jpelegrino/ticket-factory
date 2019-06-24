package com.ticketsh.ticketshow.entities;

import javax.persistence.*;

@Entity
@Table(name = "tk_fac_ticket")
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "ticket_store_id")
    private TicketStore ticketStore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public TicketStore getTicketStore() {
        return ticketStore;
    }

    public void setTicketStore(TicketStore ticketStore) {
        this.ticketStore = ticketStore;
    }
}
