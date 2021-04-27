package com.travels.travel.endpoint.controller;

import com.travels.travel.domain.service.TravelService;
import com.travels.travel.dto.TravelDTO;
import com.travels.travel.persistence.model.Travel;
import com.travels.travel.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/public/travels")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService){
        this.travelService = travelService;
    }

    @PostMapping(value = "/")
    public TravelDTO saveTravel(@RequestBody Travel travel){
        return this.travelService.saveTravel(travel);
    }

    @PostMapping(value = "/mul")
    public List<TravelDTO> saveTravels(@RequestBody List<Travel> travels){
        List<TravelDTO> finalList = new ArrayList<>();
        travels.forEach(travel -> {
            finalList.add(this.travelService.saveTravel(travel));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public TravelDTO updateTravel(@PathVariable Integer id, @RequestBody Travel travel){
        String msg = String.format("El viaje id %s es diferente de la id de la url",travel.getId());
        Utils.validateUrlIdEqualsBodyId(id,travel.getId(),msg);
        return this.travelService.updateTravel(travel);
    }

    @PutMapping(value = "")
    public TravelDTO updateTravel(@RequestBody Travel travel){
        return this.travelService.updateTravel(travel);
    }

    @PutMapping(value = "/mul")
    public List<TravelDTO> updateTravels(@RequestBody List<Travel> travels){
        List<TravelDTO> finalList = new ArrayList<>();
        travels.forEach(travel -> {
            finalList.add(this.travelService.updateTravel(travel));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<TravelDTO> getTravel(){
        return this.travelService.getTravel();
    }

    @GetMapping(value = "/{id}")
    public TravelDTO getTravelById(@PathVariable Integer id){
        return this.travelService.getTravelById(id);
    }

    @GetMapping(value = "/passport/")
    public TravelDTO getTravelByPassport(@RequestParam String passport){
        return this.travelService.getTravelByPassport(passport);
    }

    @GetMapping(value = "/email/")
    public TravelDTO getTravelByEmail(@RequestParam String email){
        return this.travelService.getTravelByEmail(email);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTravel(@PathVariable Integer id){
        this.travelService.deleteTravel(id);
    }
}
