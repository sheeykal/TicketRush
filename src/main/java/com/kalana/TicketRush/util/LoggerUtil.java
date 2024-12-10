package com.kalana.TicketRush.util;

import com.kalana.TicketRush.model.LogEntry;
import com.kalana.TicketRush.repository.LogEntryRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class LoggerUtil {


    @Autowired
    LogEntryRepo logEntryRepo;

    @Getter
    private List<String> logs = new ArrayList<>();

    public LoggerUtil() {
    }

    public void log(String message)
    {
        logs.add(message);
        logEntryRepo.save(new LogEntry(message));
        System.out.println(("Log : " + message));;
    }
}
