package com.finartz.demo.airlineticketing.repository;

import com.finartz.demo.airlineticketing.model.Flight;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository(value = "flightRepository")
public class FlightRepository extends BaseRepository<Flight> {

    public FlightRepository() {
        super();
    }

    @Override
    public Class<Flight> getClassType() {
        return Flight.class;
    }

    public Flight findFlightByFlightNumberAndDate(Timestamp flightDate, int flightNumber, String flightCarrier) {
        return entityManager.createNamedQuery("findFlightByFlightNumberDateCarrier", Flight.class).
                setParameter("flightDate", flightDate).
                setParameter("flightNumber", flightNumber).
                setParameter("fcShortCode", flightCarrier).getSingleResult();
    }
}
