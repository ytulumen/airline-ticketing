package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Airport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "airport")
public class AirportController extends BaseController<Airport> {
}
