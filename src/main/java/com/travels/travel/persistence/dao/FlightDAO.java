package com.travels.travel.persistence.dao;

import com.travels.travel.error.ErrorHandling;
import com.travels.travel.exceptions.TravelException;
import com.travels.travel.persistence.model.Flight;
import com.travels.travel.persistence.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightDAO {

    @Autowired
    private FlightRepository repository;
    private final String FLIGHT = "El vuelo ";
    private final Logger log = LoggerFactory.getLogger(FlightDAO.class.getName());

    public List<Flight> getFlight(){
        log.info("getFlight");
        List<Flight> flights = new ArrayList<>();
        this.repository.findAll().forEach(flight -> flights.add(flight));
        return flights;
    }

    public Flight getFlightById(Integer id) throws TravelException {
        log.info("getFlightById {0}", id);
        return this.repository.findById(id).orElseThrow(() ->
                new TravelException(ErrorHandling.valueNotFound(FLIGHT,id)
                ));
    }

    public Flight saveFlight(Flight flight) throws TravelException {
        log.info("saveFlight ", flight);
        return this.repository.save(flight);
    }

    public Flight updateFlight(Flight flight) throws TravelException {
        if(flight.getId()!=null){
            log.info("updateFlight ", flight);
            return this.repository.save(flight);
        }else{
            log.error(ErrorHandling.valueUpdateError(FLIGHT));
            throw new TravelException(ErrorHandling.valueUpdateError(FLIGHT));
        }
    }

    public void deleteFlight(Integer id){
        log.info("deleteFlight ", id);
        this.repository.deleteById(id);
    }
    
}
