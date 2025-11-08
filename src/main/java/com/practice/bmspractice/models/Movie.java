package com.practice.bmspractice.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movie extends BaseModel {
    private String title;
    private String genre;
    private int durationInMinutes;
    private String language;
    private String director;
    private String cast; // Comma-separated list of main actors
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;
}
