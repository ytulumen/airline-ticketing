package com.finartz.demo.airlineticketing.repository;

import com.finartz.demo.airlineticketing.model.Airport;
import org.springframework.stereotype.Repository;

@Repository(value = "airportRepository")
public class AirportRepository extends BaseRepository<Airport> {
    public AirportRepository() {
        super();
    }

    @Override
    public Class<Airport> getClassType() {
        return Airport.class;
    }

    public Airport findAirportByShortCode(String shortCode) {
        return entityManager.createNamedQuery("findAirportByShortCode", Airport.class).setParameter("shortCode", shortCode).getSingleResult();
    }
}
