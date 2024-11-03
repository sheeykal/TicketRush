package com.kalana.TicketRush.service;

import com.kalana.TicketRush.Config.SystemConfig;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    public static void getConfig(SystemConfig config) {
    }

    public void startSimulation(SystemConfig config) {
        System.out.println("Simulation started");
        System.out.println(config.toString());
    }
}
