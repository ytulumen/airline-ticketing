package com.finartz.demo.airlineticketing.repository;

import com.finartz.demo.airlineticketing.model.Route;
import org.springframework.stereotype.Repository;

@Repository(value = "routeRepository")
public class RouteRepository extends BaseRepository<Route> {

    public RouteRepository() {
        super();
    }

    @Override
    public Class<Route> getClassType() {
        return Route.class;
    }

    public Route findRouteByArrivalAndDestination(String fromShortCode, String toShortCode) {
        return entityManager.createNamedQuery("findRouteByArrivalAndDestination", Route.class).
                setParameter("fromShortCode", fromShortCode).
                setParameter("toShortCode", toShortCode).setMaxResults(1).getSingleResult();

    }
}
