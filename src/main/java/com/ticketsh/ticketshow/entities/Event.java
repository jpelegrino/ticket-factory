package com.ticketsh.ticketshow.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tk_fac_event")
public class Event implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_date")
    private Date eventDate;
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "seat_quantity")
    private Long seatQuantity;
    private String location;
    private Long status;


    public Event(Date eventDate, String eventName, Long seatQuantity, String location) {
        this.eventDate = eventDate;
        this.eventName = eventName;
        this.seatQuantity = seatQuantity;
        this.location = location;
    }

    public Event() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getSeatQuantity() {
        return seatQuantity;
    }

    public void setSeatQuantity(Long seatQuantity) {
        this.seatQuantity = seatQuantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
