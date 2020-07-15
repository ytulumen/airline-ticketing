package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Route;
import com.finartz.demo.airlineticketing.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "route")
public class RouteController extends BaseController<Route> {
    @Autowired
    private RouteService routeService;

    @GetMapping(path = "/findRoute/from={from}/to={to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Route get(@PathVariable("from") String from,
                     @PathVariable("to") String to) {
        return routeService.findRouteByArrivalAndDestination(from, to);
    }
}
