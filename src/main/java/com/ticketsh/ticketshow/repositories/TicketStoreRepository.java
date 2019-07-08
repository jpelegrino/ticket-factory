package com.ticketsh.ticketshow.repositories;

import com.ticketsh.ticketshow.entities.TicketStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketStoreRepository extends JpaRepository<TicketStore,Long>{

    @Query(value = "SELECT TS FROM TicketStore TS WHERE TS.section=:sec AND TS.rowNumber=:rown" +
            " AND TS.seatNumber=:seat")
    TicketStore findTicketStore(@Param("rown") Long row,@Param("sec") Long section, @Param("seat")Long seat);
    Optional<TicketStore> findById(Long id);
}
