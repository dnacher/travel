package com.travels.travel.domain.service;

import com.travels.travel.domain.service.mappers.TravelMapper;
import com.travels.travel.dto.TravelDTO;
import com.travels.travel.persistence.dao.TravelDAO;
import com.travels.travel.persistence.model.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TravelService {

    @Autowired
    private final TravelDAO travelDAO;
    private final TravelMapper travelMapper;

    public TravelService(TravelDAO travelDAO, TravelMapper travelMapper){
        this.travelMapper= travelMapper;
        this.travelDAO = travelDAO;
    }

    public List<TravelDTO> getTravel() {
        return travelMapper.mapToDTOList(travelDAO.getTravel());
    }

    public TravelDTO getTravelById(Integer id) {
        return travelMapper.mapToDTO(travelDAO.getTravelById(id));
    }

    public TravelDTO getTravelByPassport(String passport){
        return travelMapper.mapToDTO(travelDAO.getTravelByPassport(passport));
    }

    public TravelDTO getTravelByEmail(String email){
        return travelMapper.mapToDTO(travelDAO.getTravelByEmail(email));
    }

    public TravelDTO saveTravel(Travel travel) {
        return travelMapper.mapToDTO(travelDAO.saveTravel(travel));
    }

    public TravelDTO updateTravel(Travel travel) {
        return travelMapper.mapToDTO(travelDAO.updateTravel(travel));
    }

    public void deleteTravel(Integer id) {
        travelDAO.deleteTravel(id);
    }
}
