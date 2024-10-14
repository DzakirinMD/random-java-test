package com.zack.service;

import com.zack.model.BookingConclusion;

/**
 * Interface for managing booking services.
 */
public interface IBookingService {

    /**
     * If the sum of tickets booked and tickets that are under booking for the event with eventId
     * is strictly less than the capacity of the auditorium, implement logic to start booking a seat
     * for the user with userId for this event and return true. Otherwise, return false.
     *
     * @param eventId the ID of the event
     * @param userId the ID of the user attempting to book
     * @return true if booking process is successful, false otherwise
     */
    boolean startBookingProcess(int eventId, int userId);

    /**
     * If the booking is successful, set bookingSuccessful to true and store the booking for the userId
     * for eventId. Return a BookingConclusion object that holds the auditoriumNumber where the event will occur
     * and whether the booking is confirmed.
     *
     * @param eventId the ID of the event
     * @param userId the ID of the user
     * @param bookingSuccessful true if the booking is successful, false if not
     * @return a BookingConclusion with the auditorium number and the booking status
     */
    BookingConclusion confirmBookingStatus(int eventId, int userId, boolean bookingSuccessful);
}
