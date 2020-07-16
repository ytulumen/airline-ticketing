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

    public Flight findFlightByFlightNumberAndDate(Flight flight) {
        return entityManager.createNamedQuery("findFlightByFlightNumberDateCarrier", Flight.class).
                setParameter("flightDate", flight.getFlightDate()).
                setParameter("flightNumber", flight.getFlightNumber()).
                setParameter("fcShortCode", flight.getFlightCarrier().getShortCode()).getSingleResult();
    }

    public Flight incrementCapacityTenPercent(Flight flight) {
        flight.setCapacity((int) (flight.getCapacity() + flight.getCapacity() * 0.1f));
        flight.setTicketCharge(flight.getTicketCharge() + flight.getTicketCharge() * 0.1f);

        return super.save(flight);
    }
}
