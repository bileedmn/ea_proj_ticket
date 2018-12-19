package edu.mum.dao;

import edu.mum.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface FlightRepo extends CrudRepository<Flight, Long> {
}
