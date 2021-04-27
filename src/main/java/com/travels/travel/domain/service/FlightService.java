package com.travels.travel.domain.service;

import com.travels.travel.domain.service.mappers.FlightMapper;
import com.travels.travel.dto.FlightDTO;
import com.travels.travel.persistence.dao.FlightDAO;
import com.travels.travel.persistence.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FlightService {

    private final FlightMapper flightMapper;
    private final FlightDAO flightDAO;

    @Autowired
    public FlightService(FlightMapper flightMapper, FlightDAO flightDAO){
        this.flightDAO = flightDAO;
        this.flightMapper = flightMapper;
    }

    public List<FlightDTO> getFlight() {
        return flightMapper.mapToDTOList(flightDAO.getFlight());
    }

    public FlightDTO getFlightById(Integer id) {
        return flightMapper.mapToDTO(flightDAO.getFlightById(id));
    }

    public Flight saveFlight(Flight flight) {
        return flightDAO.saveFlight(flight);
    }

    public Flight updateFlight(Flight flight) {
        return flightDAO.updateFlight(flight);
    }

    public void deleteFlight(Integer id) {
        flightDAO.deleteFlight(id);
    }
}
