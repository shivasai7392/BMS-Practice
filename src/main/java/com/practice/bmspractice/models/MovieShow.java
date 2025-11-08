package com.practice.bmspractice.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class MovieShow extends BaseModel {
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    @Enumerated(EnumType.ORDINAL)
    private Language language;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
