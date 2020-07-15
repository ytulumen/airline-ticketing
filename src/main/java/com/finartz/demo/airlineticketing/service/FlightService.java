package com.finartz.demo.airlineticketing.service;


import com.finartz.demo.airlineticketing.model.Airline;
import com.finartz.demo.airlineticketing.model.Flight;
import com.finartz.demo.airlineticketing.model.Route;
import com.finartz.demo.airlineticketing.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.sql.Timestamp;

@Service(value = "flightService")
public class FlightService extends BaseService<Flight> {
    @Autowired
    private AirlineService airlineService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private FlightRepository repository;

    @Override
    public Flight save(Flight flight) {
        Airline airline;

        try {
            airline = airlineService.findAirlineByShortCode(flight.getFlightCarrier().getShortCode());
        } catch (NoResultException ex) {
            airline = airlineService.save(flight.getFlightCarrier());
        }

        flight.setFlightCarrier(airline);

        Route route;

        try {
            route = routeService.findRouteByArrivalAndDestination(flight.getRoute().getFrom().getShortCode(),
                    flight.getRoute().getTo().getShortCode());
        } catch (NoResultException ex) {
            route = routeService.save(flight.getRoute());
        }

        flight.setRoute(route);

        return super.save(flight);
    }

    public Flight findFlightByFlightNumberAndDate(Timestamp flightDate, int flightNumber, String flightCarrier) {
        return repository.findFlightByFlightNumberAndDate(flightDate, flightNumber, flightCarrier);
    }

}
