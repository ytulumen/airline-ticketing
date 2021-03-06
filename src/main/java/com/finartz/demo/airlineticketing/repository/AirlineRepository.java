package com.finartz.demo.airlineticketing.repository;

import com.finartz.demo.airlineticketing.model.Airline;
import org.springframework.stereotype.Repository;

@Repository(value = "airlineRepository")
public class AirlineRepository extends BaseRepository<Airline> {

    public AirlineRepository() {
        super();
    }

    @Override
    public Class<Airline> getClassType() {
        return Airline.class;
    }

    public Airline findAirlineByShortCode(String shortCode) {
        return entityManager.createNamedQuery("findAirlineByShortCode", Airline.class).setParameter("shortCode", shortCode).getSingleResult();
    }
}
