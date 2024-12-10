package com.kalana.TicketRush.Controller;

import com.kalana.TicketRush.Config.SystemConfig;
import com.kalana.TicketRush.service.SimulationService;
import com.kalana.TicketRush.util.LoggerUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket-rush")
@CrossOrigin
public class SimulationController {

    private final SimulationService  simulationService;
    private final LoggerUtil loggerUtil;

    public SimulationController(SimulationService simulationService, LoggerUtil loggerUtil)
    {
        this.simulationService = simulationService;
        this.loggerUtil = loggerUtil;
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
    public void startSimulation(@RequestBody SystemConfig config)
    {
        System.out.println(config.toString());
        simulationService.startSimulation(config);
    }

    @PostMapping("/stop-simulation")
    public String stopSimulation()
    {
        return simulationService.stopSimulation();
    }

    @GetMapping("/logs")
    public List<String> getLogs() {
        return loggerUtil.getLogs();
    }
}
