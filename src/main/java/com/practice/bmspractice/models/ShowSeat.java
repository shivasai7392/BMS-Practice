package com.practice.bmspractice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeat extends BaseModel {
    private SeatStatus seatStatus;
    @ManyToOne
    private MovieShow movieShow;
    @ManyToOne
    private Seat seat;
}
