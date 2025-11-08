package com.practice.bmspractice.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Auditorium extends BaseModel{
    private String name;
    @ManyToOne
    private Theatre theatre;
    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
