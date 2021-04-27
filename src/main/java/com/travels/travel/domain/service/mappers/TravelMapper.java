package com.travels.travel.domain.service.mappers;

import com.travels.travel.dto.TravelDTO;
import com.travels.travel.persistence.model.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TravelMapper implements AbstractMapper<Travel, TravelDTO>{

    @Autowired
    private FlightMapper flightMapper;

    @Override
    public Travel mapToEntity(TravelDTO dto) {
        Travel travel = new Travel();
        travel.setId(dto.getId());
        travel.setEmail(dto.getEmail());
        travel.setPassport(dto.getPassport());
        travel.setPassengerName(dto.getPassengerName());
        travel.setPassengerBirthDate(dto.getPassengerBirthDate());
        travel.setFlights(flightMapper.mapToEntityList(dto.getFlights()));
        return travel;
    }

    public List<Travel> mapToEntityList(List<TravelDTO> travelDTOList){
        List<Travel> finalList = new ArrayList<>();
        for(TravelDTO travelDTO: travelDTOList){
            finalList.add(mapToEntity(travelDTO));
        }
        return finalList;
    }

    @Override
    public TravelDTO mapToDTO(Travel entity) {
        TravelDTO travelDTO = new TravelDTO();
        travelDTO.setId(entity.getId());
        travelDTO.setEmail(entity.getEmail());
        travelDTO.setPassport(entity.getPassport());
        travelDTO.setPassengerName(entity.getPassengerName());
        travelDTO.setPassengerBirthDate(entity.getPassengerBirthDate());
        travelDTO.setFlights(flightMapper.mapToDTOList(entity.getFlights()));
        return travelDTO;
    }

    public List<TravelDTO> mapToDTOList(List<Travel> entities){
        List<TravelDTO> finalList = new ArrayList<>();
        for(Travel travel: entities){
            finalList.add(mapToDTO(travel));
        }
        return finalList;
    }
}
