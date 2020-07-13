package com.finartz.demo.airlineticketing.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route extends BaseModel {

    @OneToOne
    @JoinColumn(name = "from", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Airport from;

    @OneToOne
    @JoinColumn(name = "to", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Airport to;

    public Route() {
    }

    public Route(Airport from, Airport to) {
        this.from = from;
        this.to = to;
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Route{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
