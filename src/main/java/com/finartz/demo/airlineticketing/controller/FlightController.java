package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Flight;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "flight")
public class FlightController extends BaseController<Flight> {
}
