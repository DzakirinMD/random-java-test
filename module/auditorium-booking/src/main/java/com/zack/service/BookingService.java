package com.zack.service;

import com.zack.model.BookingConclusion;
import com.zack.repository.IRepo;

class BookingService implements IBookingService {
    public IRepo repo;

    public BookingService(IRepo repo) {
        this.repo = repo;
    }

    @Override
    public boolean startBookingProcess(int eventId, int userId) {
        var auditorium = repo.getAuditoriumDetailsForEvent(eventId);
        if (auditorium == null) {
            System.out.println("Event not found.");
            return false;
        }

        // If the total is less than the auditorium capacity, proceed with booking
        var totalSeatsBookedOrUnderBooking = repo.getNumberOfSeatsBooksOrUnderBookingForEvent(eventId);
        if (totalSeatsBookedOrUnderBooking < auditorium.capacity()) {
            // Available seats and add user to underbooking
            repo.addUnderBooking(eventId, userId);
            return true;
        } else {
            // No Available seats, booking fail
            return false;
        }
    }

    @Override
    public BookingConclusion confirmBookingStatus(int eventId, int userId, boolean bookingSuccessful) {
        var auditorium = repo.getAuditoriumDetailsForEvent(eventId);
        // If event does not exist, return a BookingConclusion with false status
        if (auditorium == null) {
            return new BookingConclusion(false, -1);
        }

        // If totalSeatsBookedOrUnderBooking 0 or = seat booked then treat as booking process not yet start
        var totalSeatsBookedOrUnderBooking = repo.getNumberOfSeatsBooksOrUnderBookingForEvent(eventId);
        if (totalSeatsBookedOrUnderBooking == 0 || totalSeatsBookedOrUnderBooking ==  auditorium.seatsBooked()) {
            return new BookingConclusion(false, auditorium.auditoriumNumber());
        }

        // If bookingSucess is false , remove the user from the underbooking
        if (!bookingSuccessful) {
            repo.removeUnderBooking(eventId, userId);
            return new BookingConclusion(false, auditorium.auditoriumNumber());
        }

        // If bookingSucess is true , complete the booking process
        repo.addSuccessfulBooking(eventId, userId);
        return new BookingConclusion(true, auditorium.auditoriumNumber());
    }
}
