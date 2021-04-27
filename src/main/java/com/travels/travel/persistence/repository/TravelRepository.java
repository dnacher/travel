package com.travels.travel.persistence.repository;

import com.travels.travel.persistence.model.Travel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Integer> {
    Optional<Travel> getTravelsByEmail(String email);
    Optional<Travel> getTravelsByPassport(String passport);
}
