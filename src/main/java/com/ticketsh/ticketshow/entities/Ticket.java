package com.ticketsh.ticketshow.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "tk_fac_ticket")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(description = "The resulting ticket")
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @ManyToOne
    @JoinColumn(name = "event_id")
    @ApiModelProperty(notes = "Event related to the ticket")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "ticket_store_id")
    @ApiModelProperty(notes = "Detail of selected ticket")
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
