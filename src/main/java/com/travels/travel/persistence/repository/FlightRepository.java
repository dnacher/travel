package com.travels.travel.persistence.repository;

import com.travels.travel.persistence.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer> {
}
