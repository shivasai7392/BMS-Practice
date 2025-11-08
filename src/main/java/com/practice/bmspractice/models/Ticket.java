package com.practice.bmspractice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel {
    @ManyToOne
    private User user;
    @OneToOne
    private MovieShow movieShow;
    @ManyToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;
    private double price;
    private Date BookingTime;
    @OneToMany
    private List<Payment> payments;
}
