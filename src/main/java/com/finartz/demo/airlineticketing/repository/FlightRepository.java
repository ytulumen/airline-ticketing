package com.finartz.demo.airlineticketing.repository;

import com.finartz.demo.airlineticketing.model.Flight;
import org.springframework.stereotype.Repository;

@Repository(value = "flightRepository")
public class FlightRepository extends BaseRepository<Flight> {

    public FlightRepository() {
        super();
    }

    @Override
    public Class<Flight> getClassType() {
        return Flight.class;
    }
}
