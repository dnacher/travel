package com.travels.travel.persistence.dao;

import com.travels.travel.error.ErrorHandling;
import com.travels.travel.exceptions.TravelException;
import com.travels.travel.persistence.model.Airport;
import com.travels.travel.persistence.repository.AirportRepository;
import com.travels.travel.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirportDAO {

    @Autowired
    private AirportRepository repository;
    private final String AIRPORT = "El Aeropuerto ";
    private final Logger log = LoggerFactory.getLogger(AirportDAO.class.getName());

    public List<Airport> getAirport(){
        log.info("getAirport");
        List<Airport> airports = new ArrayList<>();
        this.repository.findAll().forEach(airport -> airports.add(airport));
        return airports;
    }

    public Airport getAirportById(Integer id) throws TravelException {
        log.info(Utils.getValue("getAirportById ",id), id);
        return this.repository.findById(id).orElseThrow(() ->
                new TravelException(ErrorHandling.valueNotFound(AIRPORT,id)));
    }

    public Airport saveAirport(Airport airport) throws TravelException {
        log.info("saveAirport ", airport);
        return this.repository.save(airport);
    }

    public Airport updateAirport(Airport airport) throws TravelException {
        if(airport.getId()!=null){
            log.info("updateAirport ", airport);
            return this.repository.save(airport);
        }else{
            log.error(ErrorHandling.valueUpdateError(AIRPORT));
            throw new TravelException(ErrorHandling.valueUpdateError(AIRPORT));
        }
    }

    public void deleteAirport(Integer id){
        log.info("deleteAirport ", id);
        this.repository.deleteById(id);
    }
    
}
