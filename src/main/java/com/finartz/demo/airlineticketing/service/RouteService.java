package com.finartz.demo.airlineticketing.service;

import com.finartz.demo.airlineticketing.model.Airport;
import com.finartz.demo.airlineticketing.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service(value = "routeService")
public class RouteService extends BaseService<Route> {
    @Autowired
    private AirportService airportService;

    @Override
    public Route save(Route object) {
        Airport from;
        Airport to;

        try{
            from = airportService.findAirportByShortCode(object.getFrom().getShortCode());
        } catch (NoResultException ex){
            from = airportService.save(object.getFrom());
        }

        try{
            to = airportService.findAirportByShortCode(object.getTo().getShortCode());
        } catch (NoResultException ex){
            to = airportService.save(object.getTo());
        }

        object.setFrom(from);
        object.setTo(to);

        return super.save(object);
    }
}
