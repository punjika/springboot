package project.demo.entity;

// public class EventSchedule {

// }
// package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "event_schedules")
public class EventSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime time;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Long venueID;
    private Long coordinatorID;

    // Constructors, Getters, and Setters

    public EventSchedule() {}

    public EventSchedule(LocalTime time, LocalDate date, Long venueID, Long coordinatorID) {
        this.time = time;
        this.date = date;
        this.venueID = venueID;
        this.coordinatorID = coordinatorID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getVenueID() {
        return venueID;
    }

    public void setVenueID(Long venueID) {
        this.venueID = venueID;
    }

    public Long getCoordinatorID() {
        return coordinatorID;
    }

    public void setCoordinatorID(Long coordinatorID) {
        this.coordinatorID = coordinatorID;
    }

    // Getters and setters
    
}

