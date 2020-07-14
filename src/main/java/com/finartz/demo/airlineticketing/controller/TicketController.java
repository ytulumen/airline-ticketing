package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Ticket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController extends BaseController<Ticket> {
}
