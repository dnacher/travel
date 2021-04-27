package com.travels.travel.domain.service;

import com.travels.travel.persistence.dao.AirportDAO;
import com.travels.travel.persistence.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirportService {

    @Autowired
    private AirportDAO airportDAO;

    public List<Airport> getAirport() {
        return airportDAO.getAirport();
    }

    public Airport getAirportById(Integer id) {
        return airportDAO.getAirportById(id);
    }

    public Airport saveAirport(Airport airport) {
        return airportDAO.saveAirport(airport);
    }

    public Airport updateAirport(Airport airport) {
        return airportDAO.updateAirport(airport);
    }

    public void deleteAirport(Integer id) {
        airportDAO.deleteAirport(id);
    }
}
