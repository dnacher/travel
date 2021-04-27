package com.travels.travel.persistence.repository;

import com.travels.travel.persistence.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Integer> {

}
