package com.practice.bmspractice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private SeatType seatType;
    private double amount;
    @ManyToOne
    private MovieShow movieShow;
}
