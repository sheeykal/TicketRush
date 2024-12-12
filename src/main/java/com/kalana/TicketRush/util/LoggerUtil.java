package com.kalana.TicketRush.util;

import com.kalana.TicketRush.model.LogEntry;
import com.kalana.TicketRush.repository.LogEntryRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


@Component
@AllArgsConstructor
public class LoggerUtil {

    @Autowired
    private LogEntryRepo logEntryRepo;

    @Getter
    private final BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();


    public void log(String message, long simulationId)
    {
        logQueue.offer(message);
        logEntryRepo.save(new LogEntry(message, simulationId));
        System.out.println("Log: " + message);

    }



}