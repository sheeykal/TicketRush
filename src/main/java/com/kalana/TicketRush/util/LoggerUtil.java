package com.kalana.TicketRush.util;

import com.kalana.TicketRush.model.LogEntry;
import com.kalana.TicketRush.repository.LogEntryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoggerUtil {

    LogEntryRepo logEntryRepo;

    public void log(String message)
    {
        logEntryRepo.save(new LogEntry(message));
        System.out.println(("message: " + message));;

        //make this return method to return the message so that controller can create a service obj and one it start the
    }
}
