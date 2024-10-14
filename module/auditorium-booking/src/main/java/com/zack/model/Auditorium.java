package com.zack.model;

public record Auditorium(
        int auditoriumNumber,
        int eventId,
        int capacity,
        int seatsBooked,
        int seatsUnderBooking){}
