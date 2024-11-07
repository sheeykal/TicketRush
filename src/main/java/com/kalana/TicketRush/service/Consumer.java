package com.kalana.TicketRush.service;

import com.kalana.TicketRush.model.Ticket;
import com.kalana.TicketRush.repository.TicketRepo;
import com.kalana.TicketRush.util.LoggerUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Consumer implements Runnable {
    private final TicketPool ticketPool;
    private final LoggerUtil logger;
    private final int consumerId;
    private final int consumerRetreivalRate;

    @Override
    public void run() {
        while (true) try {
            Ticket ticket = ticketPool.consumeTicket();
            if (ticket != null) {
                logger.log("Consumer with ID: " + consumerId + "Consumed Ticket: " + ticket.getId());
            } else {
                logger.log("Consumer with ID: " + consumerId + "Did't consumed tickrt since the pool is null");
            }
            Thread.sleep(consumerRetreivalRate * 1000L);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}
