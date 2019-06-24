package com.ticketsh.ticketshow.repositories;

import com.ticketsh.ticketshow.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
}
