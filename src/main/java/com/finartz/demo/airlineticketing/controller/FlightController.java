package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Flight;
import com.finartz.demo.airlineticketing.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "flight")
public class FlightController extends BaseController<Flight> {
    @Autowired
    private FlightService flightService;

/*    @GetMapping(path = "/findFlight/flightCarrier={flightCarrier}/flightNumber={flightNumber}/flightDate={flightDate}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flight get(@PathVariable("flightCarrier") String flightCarrier,
                      @PathVariable("flightNumber") int flightNumber,
                      @PathVariable("flightDate") String flightDate) {
        return flightService.findFlightByFlightNumberAndDate(Timestamp.valueOf(flightDate), flightNumber, flightCarrier);
    }*/

    @PostMapping(path = "/findFlight", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flight getFlights(@RequestBody Flight flight) {
        return flightService.findFlightByFlightNumberAndDate(flight);
    }

    @PutMapping(path = "/incrementCapacityTenPercent", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flight incrementCapacityTenPercent(@RequestBody Flight flight) {
        return flightService.incrementCapacityTenPercent(flight);
    }
}
