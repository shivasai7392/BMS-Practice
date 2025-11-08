package com.practice.bmspractice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    @ManyToOne
    private SeatType seatType;
    @ManyToOne
    private Auditorium auditorium;
    private int irowNumber;
    private int icolumnNumber;
}
