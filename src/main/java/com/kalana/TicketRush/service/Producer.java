package com.kalana.TicketRush.service;

import com.kalana.TicketRush.model.Ticket;
import com.kalana.TicketRush.repository.TicketRepo;
import com.kalana.TicketRush.util.LoggerUtil;
import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicBoolean;

@AllArgsConstructor
public class Producer implements Runnable{
    private final TicketPool ticketPool;
    private final LoggerUtil logger;
    private final TicketRepo ticketRepo;
    private final int producerId;
    private final AtomicBoolean stopFlag;
    private final int totalTicket;


    @Override
    public void run()
    {
        if (stopFlag.get())
        {
            logger.log("Producer with ID: " + producerId + " stopping due to User stopped the simulation");
        } else if (ticketPool.getProducedTicketCount() >= totalTicket) {
            logger.log("Producer with ID: " + producerId + " stopping as all tickets are produced");
        }

        if(Thread.currentThread().isInterrupted())
        {
            logger.log("Producer with ID: " + producerId + " stopping due to Interruption");
        }

        if (ticketPool.getCurrentTicketInthePool() < ticketPool.getTicketPoolCapacity())
        {
            Ticket ticket = new Ticket();
            ticketPool.produceTicket(ticket);
            ticketRepo.save(ticket);
            logger.log("Producer with ID: " + producerId + " has been produced a ticket with ID: " + ticket.getId());
        } else {
            logger.log("Producer with ID: " + producerId + "is waiting because the Pool is full");
        }
                    }
    }