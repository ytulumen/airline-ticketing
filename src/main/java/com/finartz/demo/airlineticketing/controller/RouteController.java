package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Route;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "route")
public class RouteController extends BaseController<Route> {
}
