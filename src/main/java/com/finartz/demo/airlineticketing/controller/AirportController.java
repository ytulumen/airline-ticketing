package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Airport;
import com.finartz.demo.airlineticketing.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "airport")
public class AirportController extends BaseController<Airport> {

    @Autowired
    private AirportService airportService;

    @GetMapping(path = "/findByShortCode/{shortCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Airport get(@PathVariable("shortCode") String shortCode) {
        return airportService.findAirportByShortCode(shortCode);
    }
}
