package com.practice.bmspractice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel {
    private SeatStatus seatStatus;
    @ManyToOne
    private MovieShow movieShow;
    @ManyToOne
    private Seat seat;
    private Date LockedAt;
}
