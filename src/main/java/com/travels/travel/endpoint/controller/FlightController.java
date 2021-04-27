package com.travels.travel.endpoint.controller;

import com.travels.travel.domain.service.FlightService;
import com.travels.travel.dto.FlightDTO;
import com.travels.travel.persistence.model.Flight;
import com.travels.travel.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/public/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @PostMapping(value = "/")
    public Flight saveFlight(@RequestBody Flight flight){
        return this.flightService.saveFlight(flight);
    }

    @PostMapping(value = "/mul")
    public List<Flight> saveFlights(@RequestBody List<Flight> flights){
        List<Flight> finalList = new ArrayList<>();
        flights.forEach(flight -> {
            finalList.add(this.flightService.saveFlight(flight));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public Flight updateFlight(@PathVariable Integer id, @RequestBody Flight flight){
        String msg = String.format("El vuelo id %s es diferente de la id de la url",flight.getId());
        Utils.validateUrlIdEqualsBodyId(id,flight.getId(),msg);
        return this.flightService.updateFlight(flight);
    }

    @PutMapping(value = "")
    public Flight updateFlight(@RequestBody Flight flight){
        return this.flightService.updateFlight(flight);
    }

    @PutMapping(value = "/mul")
    public List<Flight> updateFlights(@RequestBody List<Flight> flights){
        List<Flight> finalList = new ArrayList<>();
        flights.forEach(flight -> {
            finalList.add(this.flightService.updateFlight(flight));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<FlightDTO> getFlight(){
        return this.flightService.getFlight();
    }

    @GetMapping(value = "/{id}")
    public FlightDTO getFlightById(@PathVariable Integer id){
        return this.flightService.getFlightById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFlight(@PathVariable Integer id){
        this.flightService.deleteFlight(id);
    }
}
