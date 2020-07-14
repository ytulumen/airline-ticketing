package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Airline;
import com.finartz.demo.airlineticketing.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airline")
public class AirlineController extends BaseController<Airline> {
    @Autowired
    private AirlineService airlineService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String get(ModelMap map) {
        System.out.println("nabrrrrr");
        return "heloo";
    }


}
