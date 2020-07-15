package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Flight;
import com.finartz.demo.airlineticketing.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "flight")
public class FlightController extends BaseController<Flight> {
    @Autowired
    private FlightService flightService;

    @GetMapping(path = "/findFlight/flightCarrier={flightCarrier}/flightNumber={flightNumber}/flightDate={flightDate}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flight get(@PathVariable("flightCarrier") String flightCarrier,
                      @PathVariable("flightNumber") int flightNumber,
                      @PathVariable("flightDate") Timestamp flightDate) {
        return flightService.findFlightByFlightNumberAndDate(flightDate, flightNumber, flightCarrier);
    }
}
