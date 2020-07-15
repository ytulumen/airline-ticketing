package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Airline;
import com.finartz.demo.airlineticketing.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airline")
public class AirlineController extends BaseController<Airline> {
    @Autowired
    private AirlineService airlineService;

    @GetMapping(path = "/findByShortCode/{shortCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Airline get(@PathVariable("shortCode") String shortCode) {
        return airlineService.findAirlineByShortCode(shortCode);
    }


}
