package com.zack.repository;

import com.zack.model.Auditorium;

public interface IRepo {

    /**
     * Create and store an Auditorium object from the parameters passed to this function.
     * @param auditoriumNumber the number of the auditorium
     * @param eventId the ID of the event
     * @param capacity the seating capacity of the auditorium
     */
    void registerEventInAuditorium(int auditoriumNumber, int eventId, int capacity);

    /**
     * Return the Auditorium object that represents the auditorium where an event with eventId will occur.
     * @param eventId the ID of the event
     * @return the Auditorium object for the event
     */
    Auditorium getAuditoriumDetailsForEvent(int eventId);

    /**
     * Return the sum of tickets booked and tickets that are under booking for the event with eventId.
     * @param eventId the ID of the event
     * @return the number of seats booked or under booking for the event
     */
    int getNumberOfSeatsBooksOrUnderBookingForEvent(int eventId);

    /**
     * Store the information that the user with userId is booking an event with eventId.
     * @param eventId the ID of the event
     * @param userId the ID of the user booking the event
     */
    void addUnderBooking(int eventId, int userId);

    /**
     * Remove the information that the user with userId is booking an event with eventId.
     * @param eventId the ID of the event
     * @param userId the ID of the user to be removed from the booking
     */
    void removeUnderBooking(int eventId, int userId);

    /**
     * Store the information that the user with userId has successfully booked an event with eventId.
     * @param eventId the ID of the event
     * @param userId the ID of the user who successfully booked
     */
    void addSuccessfulBooking(int eventId, int userId);
}
