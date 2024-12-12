package com.kalana.TicketRush.service;

import com.kalana.TicketRush.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketPool {
    private final int ticketPoolCapacity;
    private final BlockingQueue<Ticket> ticketPool;
    private final AtomicInteger producedTicketCount = new AtomicInteger(0);
    private final AtomicInteger consumedTicketCount = new AtomicInteger(0);
    private final AtomicInteger currentTicketsInThePool = new AtomicInteger(0);


    public TicketPool(int ticketPoolCapacity) {
        this.ticketPoolCapacity = ticketPoolCapacity;
        this.ticketPool = new ArrayBlockingQueue<>(ticketPoolCapacity);
    }

    // Method to add ticket to ticket pool
    public synchronized void produceTicket (Ticket ticket)
    {
        ticketPool.add(ticket);
        producedTicketCount.incrementAndGet();
        currentTicketsInThePool.incrementAndGet();
    }

    // Method to remove ticket from the ticket pool
    public synchronized Ticket consumeTicket()
    {
        consumedTicketCount.incrementAndGet();
        currentTicketsInThePool.decrementAndGet();
        return ticketPool.poll();
    }

    public synchronized int getCurrentTicketsInThePool() {return currentTicketsInThePool.get();}

    public synchronized int getCurrentTicketInThePool() {return ticketPool.size();}

    public synchronized int getTicketPoolCapacity() {return ticketPoolCapacity;}

    public synchronized int getProducedTicketCount() {return consumedTicketCount.get();}

    public synchronized int getConsumedTicketCount() {return consumedTicketCount.get();}

}

