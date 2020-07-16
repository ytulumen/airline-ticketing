package com.finartz.demo.airlineticketing.service;

import com.finartz.demo.airlineticketing.model.Flight;
import com.finartz.demo.airlineticketing.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Optional;

@Service(value = "ticketService")
public class TicketService extends BaseService<Ticket> {
    @Autowired
    private FlightService flightService;

    @Transactional
    public Ticket takeTicket(Ticket ticket) {
        Flight flight;

        try {
            flight = flightService.findFlightByFlightNumberAndDate(ticket.getFlight());
        } catch (NoResultException ex) {
            flight = flightService.save(ticket.getFlight());
        }
        ticket.setFlight(flight);
        ticket.setPrice(flight.getTicketCharge());

        StringBuilder parsedCreditCardNumber = new StringBuilder();
        String creditCardNumber = ticket.getCreditCardNumber();
        int digitCounter = 0;

        for (int i = 0; i < creditCardNumber.length(); i++) {
            char ch = creditCardNumber.charAt(i);
            if (Character.isDigit(ch)) {
                ++digitCounter;
                if (digitCounter > 6 && digitCounter < 13) {
                    ch = '*';
                }
                parsedCreditCardNumber.append(ch);
            }
        }

        if (parsedCreditCardNumber.length() != 16) {
            throw new IllegalStateException("Credit card number is wrong");
        }

        ticket.setCreditCardNumber(parsedCreditCardNumber.toString());
        return super.save(ticket);
    }

    @Transactional
    public boolean cancelTicketById(long id) {
        Optional<Ticket> ticket = findById(id);

        if(ticket.isPresent()) {
            deleteById(id);
            return true;
        }

        return false;
    }
}
