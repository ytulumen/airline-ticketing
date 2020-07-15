package com.finartz.demo.airlineticketing.service;

import com.finartz.demo.airlineticketing.model.Airline;
import com.finartz.demo.airlineticketing.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "airlineService")
public class AirlineService extends BaseService<Airline> {
    @Autowired
    private AirlineRepository repository;

    public Airline findAirlineByShortCode(String shortCode) {
        return repository.findAirlineByShortCode(shortCode);
    }

}
