package com.ticketsh.ticketshow.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.NativeObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tk_fac_event")
@ApiModel(description = "Event information")
public class Event implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @ApiModelProperty(notes = "Date of the event")
    @Column(name = "event_date")
    private Date eventDate;
    @ApiModelProperty(notes = "Name of the event")
    @Column(name = "event_name")
    private String eventName;
    @ApiModelProperty(notes = "Total seats allocated for this event ")
    @Column(name = "seat_quantity")
    private Long seatQuantity;
    @ApiModelProperty(notes = "Place where the event will take place")
    private String location;
    @ApiModelProperty(notes = "Status of the event")
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;


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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
