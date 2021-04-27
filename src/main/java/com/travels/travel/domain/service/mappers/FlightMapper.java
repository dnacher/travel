package com.travels.travel.domain.service.mappers;

import com.travels.travel.dto.FlightDTO;
import com.travels.travel.persistence.model.Flight;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightMapper implements AbstractMapper<Flight, FlightDTO>{


    @Override
    public Flight mapToEntity(FlightDTO dto) {
        Flight flight = new Flight();
        flight.setId(dto.getId());
        flight.setAirportDeparture(dto.getAirportDeparture());
        flight.setAirportArrival(dto.getAirportArrival());
        flight.setDepartureDate(dto.getDepartureDate());
        flight.setArrivalDate(dto.getArrivalDate());
        flight.setAirline(dto.getAirline());
        return flight;
    }

    public List<Flight> mapToEntityList(List<FlightDTO> flightDTOList){
        List<Flight> finalList = new ArrayList<>();
        for(FlightDTO flightDTO: flightDTOList){
            finalList.add(mapToEntity(flightDTO));
        }
        return finalList;
    }

    @Override
    public FlightDTO mapToDTO(Flight entity) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setId(entity.getId());
        flightDTO.setAirportDeparture(entity.getAirportDeparture());
        flightDTO.setAirportArrival(entity.getAirportArrival());
        flightDTO.setDepartureDate(entity.getDepartureDate());
        flightDTO.setArrivalDate(entity.getArrivalDate());
        flightDTO.setAirline(entity.getAirline());
        return flightDTO;
    }

    public List<FlightDTO> mapToDTOList(List<Flight> entities){
        List<FlightDTO> finalList = new ArrayList<>();
        for(Flight flight: entities){
            finalList.add(mapToDTO(flight));
        }
        return finalList;
    }
}
