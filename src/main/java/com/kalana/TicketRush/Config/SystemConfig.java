package com.kalana.TicketRush.Config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SystemConfig {
    private int totalTicket;
    private int ticketReleaseRate;
    private int comsumerRetrevalRate;
    private int ticketPoolCapacity;

}
