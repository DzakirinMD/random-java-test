package com.zack.repository;

import com.zack.model.Auditorium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Repo implements IRepo {

    // Store Auditorium object
    private final Map<Integer, Auditorium> auditoriumMap = new HashMap<>();

    // Track user under booking for each event
    private final Map<Integer, Set<Integer>> underbookingMap = new HashMap<>();

    // Track users who have successfully booked
    private final Map<Integer, Set<Integer>> bookedUsersMap = new HashMap<>();

    @Override
    public void registerEventInAuditorium(int auditoriumNumber, int eventId, int capacity) {
        var auditorium = new Auditorium(
                auditoriumNumber,
                eventId,
                capacity,
                0,
                0
        );

        auditoriumMap.put(auditoriumNumber, auditorium);
    }

    @Override
    public Auditorium getAuditoriumDetailsForEvent(int eventId) {
        // Loop thru auditoriumMap and return matching Auditorium
        for (Auditorium auditorium : auditoriumMap.values()) {
            if (auditorium.eventId() == eventId){
                return auditorium;
            }
        }

        // Return null if event not found
        return null;
    }

    @Override
    public int getNumberOfSeatsBooksOrUnderBookingForEvent(int eventId) {
        var auditorium = getAuditoriumDetailsForEvent(eventId);
        // add all if got both
        if (auditorium != null) {
            return auditorium.seatsBooked() + auditorium.seatsUnderBooking();
        }

        // return 0 seats if event not created
        return 0;
    }

    @Override
    public void addUnderBooking(int eventId, int userId) {
        var auditorium = getAuditoriumDetailsForEvent(eventId);
        if (auditorium == null) {
            System.out.println("Event not found.");
            return;
        }

        // Get or create the set of user under booking for the event
        underbookingMap.putIfAbsent(eventId, new HashSet<>());
        Set<Integer> usersUnderBooking = underbookingMap.get(eventId);

        // Add user to the set if theyre not already booking
        if (!usersUnderBooking.contains(userId)) {
            usersUnderBooking.add(userId);

            // Update Auditorium
            var updatedAuditorium = new Auditorium(
                    auditorium.auditoriumNumber(),
                    auditorium.eventId(),
                    auditorium.capacity(),
                    auditorium.seatsBooked(),
                    auditorium.seatsUnderBooking() + 1
            );

            // Update the Auditorium in map
            auditoriumMap.put(updatedAuditorium.auditoriumNumber(), updatedAuditorium);
        }
    }

    @Override
    public void removeUnderBooking(int eventId, int userId) {
        var auditorium = getAuditoriumDetailsForEvent(eventId);
        if (auditorium == null) {
            System.out.println("Event not found.");
            return;
        }

        // check if the event has any users under booking
        Set<Integer> usersUnderBooking = underbookingMap.get(eventId);
        if (usersUnderBooking == null || !usersUnderBooking.contains(userId)) {
            System.out.println("User is not under booking for this event.");
            return;
        }

        // Remove and update user from under booking
        usersUnderBooking.remove(userId);
        var updatedAuditorium = new Auditorium(
                auditorium.auditoriumNumber(),
                auditorium.eventId(),
                auditorium.capacity(),
                auditorium.seatsBooked(),
                auditorium.seatsUnderBooking() - 1
        );
        auditoriumMap.put(updatedAuditorium.auditoriumNumber(), updatedAuditorium);

        // If no user left in underbookingMap, clean up underbookingMap
        if (usersUnderBooking.isEmpty()) {
            underbookingMap.remove(eventId);
        }

        System.out.println("User: " + userId + "removed from under booking for event: " + eventId );
    }

    @Override
    public void addSuccessfulBooking(int eventId, int userId) {
        var auditorium = getAuditoriumDetailsForEvent(eventId);
        if (auditorium == null) {
            System.out.println("Event not found.");
            return;
        }

        // check if the event has any users under booking
        Set<Integer> usersUnderBooking = underbookingMap.get(eventId);
        if (usersUnderBooking == null || !usersUnderBooking.contains(userId)) {
            System.out.println("User is not under booking for this event.");
            return;
        }

        // Remove and update user from under booking
        usersUnderBooking.remove(userId);
        var updatedAuditorium = new Auditorium(
                auditorium.auditoriumNumber(),
                auditorium.eventId(),
                auditorium.capacity(),
                auditorium.seatsBooked() + 1,
                auditorium.seatsUnderBooking() - 1
        );
        auditoriumMap.put(updatedAuditorium.auditoriumNumber(), updatedAuditorium);

        // Track sucessfully booked users
        bookedUsersMap.putIfAbsent(eventId, new HashSet<>());
        Set<Integer> bookedUsers = bookedUsersMap.get(eventId);
        bookedUsers.add(userId);

        System.out.println("User: " + userId + "succesfully booking for event: " + eventId );
    }
}
