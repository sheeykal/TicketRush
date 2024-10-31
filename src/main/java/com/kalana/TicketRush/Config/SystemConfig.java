package com.kalana.TicketRush.Config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SystemConfig {
    private int totalTicket;
    private int ticketReleaseRate;
    private int comsumerRetrevalRate;
    private int ticketPoolCapacity;



}
