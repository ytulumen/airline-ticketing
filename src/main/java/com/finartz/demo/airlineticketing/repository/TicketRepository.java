package com.finartz.demo.airlineticketing.repository;

import com.finartz.demo.airlineticketing.model.Ticket;
import org.springframework.stereotype.Repository;

@Repository(value = "ticketRepository")
public class TicketRepository extends BaseRepository<Ticket>{

    public TicketRepository() {
        super();
    }

    @Override
    public Class<Ticket> getClassType() {
        return Ticket.class;
    }
}
