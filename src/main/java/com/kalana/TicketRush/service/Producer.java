package com.kalana.TicketRush.service;

import com.kalana.TicketRush.model.Ticket;
import com.kalana.TicketRush.repository.TicketRepo;
import com.kalana.TicketRush.util.LoggerUtil;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Producer implements Runnable{
    private final TicketPool ticketPool;
    private final LoggerUtil logger;
    private final TicketRepo ticketRepo;
    private final int producerId;
    private final int ticketReleaseRate;



    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                if(ticketPool.getCurrentTicketInthePool()< ticketPool.getTicketPoolCapacity())
                {
                    Ticket ticket = new Ticket();
                    ticketPool.produceTicket(ticket);
                    ticketRepo.save(ticket);
                    logger.log("Producer " + producerId + "added ticket" + ticket.getId());
                }else
                {
                    logger.log("Ticket pool is full; Producer" + producerId + "is waiting!");
                }
                Thread.sleep(ticketReleaseRate + 1000L);
            }
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            System.out.println("Producer thread is interrupted:" + e.getMessage());
        }

    }
}
