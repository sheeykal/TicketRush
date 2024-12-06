package com.kalana.TicketRush.service;

import com.kalana.TicketRush.model.Ticket;
import com.kalana.TicketRush.util.LoggerUtil;
import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicBoolean;

@AllArgsConstructor
public class Consumer implements Runnable
{
    private final TicketPool ticketPool;
    private final LoggerUtil logger;
    private final int consumerId;
    private final AtomicBoolean stopFlag;
    private final int totalTicket;

    @Override
    public void run()
    {
        if (stopFlag.get())
        {
            logger.log("Consumer with ID: " + consumerId + " stopping due to User stopped the simulation");
        } else if (ticketPool.getProducedTicketCount() >= totalTicket) {
            logger.log("Consumer with ID: " + consumerId + " stopping as all tickets are produced");
        }

        if(Thread.currentThread().isInterrupted())
        {
            logger.log("Consumer with ID: " + consumerId + " stopping due to Interruption");
        }
            Ticket ticket = ticketPool.consumeTicket();
            if (ticket != null)
            {
                logger.log("Consumer with ID: " + consumerId + "Consumed Ticket: " + ticket.getId());
            } else {
                logger.log("Consumer with ID: " + consumerId + "Did't consumed tickrt since the pool is null");
            }

    }
}
