package com.practice.bmspractice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Theatre extends BaseModel{
    private String address;
    @OneToMany(mappedBy = "theatre")
    private List<Auditorium> auditoriums;
    @ManyToOne
    private City city;
}
