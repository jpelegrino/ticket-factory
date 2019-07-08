package com.ticketsh.ticketshow.repositories;

import com.ticketsh.ticketshow.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Query(nativeQuery = true,value = "SELECT COUNT(*) tk_fac_ticket")
    Long registeredTicket();
    Optional<Ticket> findById(Long id);
}
