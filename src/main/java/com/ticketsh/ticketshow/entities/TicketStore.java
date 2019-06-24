package com.ticketsh.ticketshow.entities;

import javax.persistence.*;

@Entity
@Table(name = "tk_fac_ticket_store")
public class TicketStore {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long section;
    @Column(name = "row_number")
    private Long rowNumber;
    @Column(name = "seat_number")
    private Long seatNumber;
    private Long status;

    public TicketStore(Long section, Long rowNumber, Long seatNumber, Long status) {
        this.section = section;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.status = status;
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
