package com.travels.travel.persistence.dao;

import com.travels.travel.error.ErrorHandling;
import com.travels.travel.exceptions.TravelException;
import com.travels.travel.persistence.model.Travel;
import com.travels.travel.persistence.repository.TravelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TravelDAO {

    @Autowired
    private TravelRepository repository;
    private final String TRAVEL = "El Viaje ";
    private final Logger log = LoggerFactory.getLogger(TravelDAO.class.getName());

    public List<Travel> getTravel(){
        log.info("getTravel");
        List<Travel> travels = new ArrayList<>();
        this.repository.findAll().forEach(travel -> travels.add(travel));
        return travels;
    }

    public Travel getTravelById(Integer id) throws TravelException {
        log.info("getTravelById %d", id);
        return this.repository.findById(id).orElseThrow(() ->
                    new TravelException(ErrorHandling.valueNotFound(TRAVEL,id)
                ));
    }

    public Travel getTravelByEmail(String email) throws TravelException {
        log.info("getTravelById {0}", email);
        return this.repository.getTravelsByEmail(email).orElseThrow(() ->
                new TravelException(ErrorHandling.valueNotFound(TRAVEL,email)
                ));
    }

    public Travel getTravelByPassport(String passport) throws TravelException {
        log.info("getTravelById {0}", passport);
        return this.repository.getTravelsByPassport(passport).orElseThrow(() ->
                new TravelException(ErrorHandling.valueNotFound(TRAVEL,passport)
                ));
    }

    public Travel saveTravel(Travel travel) throws TravelException {
        log.info("saveTravel ", travel);
        return this.repository.save(travel);
    }

    public Travel updateTravel(Travel travel) throws TravelException {
        if(travel.getId()!=null){
            log.info("updateTravel ", travel);
            return this.repository.save(travel);
        }else{
            log.error(ErrorHandling.valueUpdateError(TRAVEL));
            throw new TravelException(ErrorHandling.valueUpdateError(TRAVEL));
        }
    }

    public void deleteTravel(Integer id){
        log.info("deleteTravel ", id);
        this.repository.deleteById(id);
    }
    
}
