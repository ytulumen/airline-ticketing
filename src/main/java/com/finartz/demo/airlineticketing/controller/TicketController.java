package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.Ticket;
import com.finartz.demo.airlineticketing.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController extends BaseController<Ticket> {
    @Autowired
    private TicketService service;

    @PostMapping(path = "/takeTicket", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ticket takeTicket(@RequestBody Ticket ticket) {
        return service.takeTicket(ticket);
    }

    @DeleteMapping(path = "/cancelTicketById/ticketId={ticketId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean cancelTicketById(@PathVariable("ticketId") long ticketId) {
        return service.cancelTicketById(ticketId);
    }
}
