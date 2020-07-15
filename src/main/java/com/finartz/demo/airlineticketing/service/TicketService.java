package com.finartz.demo.airlineticketing.service;

import com.finartz.demo.airlineticketing.model.Flight;
import com.finartz.demo.airlineticketing.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service(value = "ticketService")
public class TicketService extends BaseService<Ticket> {
    @Autowired
    private FlightService flightService;

    @Override
    public Ticket save(Ticket object) {
        Flight flight;

        try {
            flight = flightService.findFlightByFlightNumberAndDate(object.getFlight().getFlightDate(), object.getFlight().getFlightNumber(), object.getFlight().getFlightCarrier().getShortCode());
        } catch (NoResultException ex) {
            flight = flightService.save(object.getFlight());
        }

        object.setFlight(flight);

        return super.save(object);
    }
}
