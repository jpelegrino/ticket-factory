package com.ticketsh.ticketshow.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tk_fac_ticket_store")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(description = "Detail about ticket Store")
public class TicketStore {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @NotNull(message = "The section should have at least 1")
    @ApiModelProperty(notes = "This is where you find a classified group of seats")
    private Long section;
    @ApiModelProperty(notes = "This is where you find a sub-classified group of seats")
    @Column(name = "row_number")
    private Long rowNumber;
    @ApiModelProperty(notes = "This is where you find a the seat")
    @Column(name = "seat_number")
    private Long seatNumber;
    @ApiModelProperty(notes = "This field give the status of the seat")
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public TicketStore(Long section, Long rowNumber, Long seatNumber, Status status) {
        this.section = section;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public TicketStore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSection() {
        return section;
    }

    public void setSection(Long section) {
        this.section = section;
    }

    public Long getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Long rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Long getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Long seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
