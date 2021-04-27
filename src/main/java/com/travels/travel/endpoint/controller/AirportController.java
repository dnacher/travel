package com.travels.travel.endpoint.controller;

import com.travels.travel.domain.service.AirportService;
import com.travels.travel.persistence.model.Airport;
import com.travels.travel.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/public/airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService){
        this.airportService = airportService;
    }

    @PostMapping(value = "/")
    public Airport saveAirport(@RequestBody Airport airport){
        return this.airportService.saveAirport(airport);
    }

    @PostMapping(value = "/mul")
    public List<Airport> saveAirports(@RequestBody List<Airport> airports){
        List<Airport> finalList = new ArrayList<>();
        airports.forEach(airport -> {
            finalList.add(this.airportService.saveAirport(airport));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public Airport updateAirport(@PathVariable Integer id, @RequestBody Airport airport){
        String msg = String.format("El aeropuerto id %s es diferente de la id de la url",airport.getId());
        Utils.validateUrlIdEqualsBodyId(id,airport.getId(),msg);
        return this.airportService.updateAirport(airport);
    }

    @PutMapping(value = "")
    public Airport updateAirport(@RequestBody Airport airport){
        return this.airportService.updateAirport(airport);
    }

    @PutMapping(value = "/mul")
    public List<Airport> updateAirports(@RequestBody List<Airport> airports){
        List<Airport> finalList = new ArrayList<>();
        airports.forEach(airport -> {
            finalList.add(this.airportService.updateAirport(airport));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<Airport> getAirport(){
        return this.airportService.getAirport();
    }

    @GetMapping(value = "/{id}")
    public Airport getAirportById(@PathVariable Integer id){
        return this.airportService.getAirportById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAirport(@PathVariable Integer id){
        this.airportService.deleteAirport(id);
    }
}
