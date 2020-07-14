package com.finartz.demo.airlineticketing.service;

import com.finartz.demo.airlineticketing.model.Airport;
import com.finartz.demo.airlineticketing.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "airportService")
public class AirportService extends BaseService<Airport> {
    @Autowired
    private AirportRepository repository;

    public Airport findAirportByShortCode(String shortCode) {
        return repository.findAirportByShortCode(shortCode);
    }

}
