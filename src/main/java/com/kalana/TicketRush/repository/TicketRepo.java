package com.kalana.TicketRush.repository;

import com.kalana.TicketRush.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer>
{

}
