package com.kalana.TicketRush.repository;

import com.kalana.TicketRush.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryRepo extends JpaRepository<LogEntry, Integer>
{
}
