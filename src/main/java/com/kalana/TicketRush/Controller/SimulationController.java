package com.kalana.TicketRush.Controller;

import com.kalana.TicketRush.Config.SystemConfig;
import com.kalana.TicketRush.service.SimulationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket-rush")
public class SimulationController {

    private final SimulationService simulationService;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("/")
    public String home()
    {
        return "Hello!";
    }

    @GetMapping("/getConfig")
    public SystemConfig getConfig()
    {
        return new SystemConfig(500,2,3,100);
    }

    @PostMapping("/start-simulation")
    public String startSimulation(@RequestBody SystemConfig config)
    {
        return simulationService.startSimulation(config);
    }

    @PostMapping("/stop-simulation")
    public String stopSimulation()
    {
        return simulationService.stopSimulation();
    }
}
