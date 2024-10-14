package com.zack.service

import com.zack.repository.Repo
import spock.lang.Specification

class BookingServiceTest extends Specification {
    def "cannot start booking process if an event is not registered"() {
        given: "we have a list of events"
        def repo = new Repo()
        repo.registerEventInAuditorium(5, 6, 2)
        repo.registerEventInAuditorium(7, 3, 5)

        when: "we start a booking process for an event that is not registered"
        def bookingService = new BookingService(repo)
        def user1Registered = bookingService.startBookingProcess(7, 1)
        def user2Registered = bookingService.startBookingProcess(2, 2)

        then: "users are not registered"
        assert !user1Registered
        assert !user2Registered
    }

    def "cannot confirm booking status if booking process has not been started"() {
        given: "we have a list of events"
        def repo = new Repo()
        repo.registerEventInAuditorium(5, 6, 2)
        repo.registerEventInAuditorium(7, 3, 5)

        when: "we confirm a booking status which has not been started"
        def bookingService = new BookingService(repo)
        def user1BookingConclusion = bookingService.confirmBookingStatus(6, 1, true)
        def user2BookingConclusion = bookingService.confirmBookingStatus(3, 2, false)
        def user3BookingConclusion = bookingService.confirmBookingStatus(6, 3, false)
        def user4BookingConclusion = bookingService.confirmBookingStatus(3, 4, true)

        then: "bookings are not confirmed"
        assert !user1BookingConclusion.isSuccessful()
        assert !user2BookingConclusion.isSuccessful()
        assert !user3BookingConclusion.isSuccessful()
        assert !user4BookingConclusion.isSuccessful()
    }

    def "can start booking process for a registered event as long as it has not been fully booked"() {
        given: "we have a list of events"
        def repo = new Repo()
        repo.registerEventInAuditorium(5, 6, 2)
        repo.registerEventInAuditorium(7, 3, 5)

        when: "we start booking processes for an event that is registered but not fully booked"
        def bookingService = new BookingService(repo)
        def user1Registered = bookingService.startBookingProcess(6, 1)
        def user2Registered = bookingService.startBookingProcess(3, 2)
        def user3Registered = bookingService.startBookingProcess(6, 3)
        def user4Registered = bookingService.startBookingProcess(3, 4)

        then: "users are registered"
        assert user1Registered
        assert user2Registered
        assert user3Registered
        assert user4Registered
    }

    def "can confirm booking as successful"() {
        given: "we have a list of events"
        def repo = new Repo()
        repo.registerEventInAuditorium(5, 6, 2)
        repo.registerEventInAuditorium(7, 3, 5)

        when: "we start and confirm a booking as successful"
        def bookingService = new BookingService(repo)
        def user1Registered = bookingService.startBookingProcess(6, 1)
        def user1BookingConclusion = bookingService.confirmBookingStatus(6, 1, true)
        def user2Registered = bookingService.startBookingProcess(3, 2)
        def user2BookingConclusion = bookingService.confirmBookingStatus(3, 2, true)
        def user3Registered = bookingService.startBookingProcess(6, 3)
        def user3BookingConclusion = bookingService.confirmBookingStatus(6, 3, true)
        def user4Registered = bookingService.startBookingProcess(3, 4)
        def user4BookingConclusion = bookingService.confirmBookingStatus(3, 4, true)

        then: "bookings are confirmed as successful"
        assert user1Registered
        assert user1BookingConclusion.isSuccessful()
        assert user1BookingConclusion.auditoriumNumber() == 5
        assert user2Registered
        assert user2BookingConclusion.isSuccessful()
        assert user2BookingConclusion.auditoriumNumber() == 7
        assert user3Registered
        assert user3BookingConclusion.isSuccessful()
        assert user3BookingConclusion.auditoriumNumber() == 5
        assert user4Registered
        assert user4BookingConclusion.isSuccessful()
        assert user4BookingConclusion.auditoriumNumber() == 7
    }

    def "can confirm booking as unsuccessful"() {
        given: "we have a list of events"
        def repo = new Repo()
        repo.registerEventInAuditorium(5, 6, 2)
        repo.registerEventInAuditorium(7, 3, 5)

        when: "we start and confirm a booking as unsuccessful"
        def bookingService = new BookingService(repo)
        def user1Registered = bookingService.startBookingProcess(6, 1)
        def user1BookingConclusion = bookingService.confirmBookingStatus(6, 1, false)
        def user2Registered = bookingService.startBookingProcess(3, 2)
        def user2BookingConclusion = bookingService.confirmBookingStatus(3, 2, false)
        def user3Registered = bookingService.startBookingProcess(6, 3)
        def user3BookingConclusion = bookingService.confirmBookingStatus(6, 3, false)
        def user4Registered = bookingService.startBookingProcess(3, 4)
        def user4BookingConclusion = bookingService.confirmBookingStatus(3, 4, false)

        then: "bookings are confirmed as unsuccessful"
        assert user1Registered
        assert !user1BookingConclusion.isSuccessful()
        assert user1BookingConclusion.auditoriumNumber() == 5
        assert user2Registered
        assert !user2BookingConclusion.isSuccessful()
        assert user2BookingConclusion.auditoriumNumber() == 7
        assert user3Registered
        assert !user3BookingConclusion.isSuccessful()
        assert user3BookingConclusion.auditoriumNumber() == 5
        assert user4Registered
        assert !user4BookingConclusion.isSuccessful()
        assert user4BookingConclusion.auditoriumNumber() == 7
    }

    def "cannot start booking process if an auditorium is fully booked"() {
        given: "we have a list of events"
        def repo = new Repo()
        repo.registerEventInAuditorium(5, 6, 2)
        repo.registerEventInAuditorium(7, 3, 5)

        when: "we start booking processes for events which are not fully booked"
        def bookingService = new BookingService(repo)
        def user1Registered = bookingService.startBookingProcess(6, 1)
        def user2Registered = bookingService.startBookingProcess(3, 2)
        def user3Registered = bookingService.startBookingProcess(6, 3)
        def user4Registered = bookingService.startBookingProcess(3, 4)
        def user5Registered = bookingService.startBookingProcess(3, 5)
        def user6Registered = bookingService.startBookingProcess(3, 6)
        def user7Registered = bookingService.startBookingProcess(3, 7)

        then: "users are registered"
        assert user1Registered
        assert user2Registered
        assert user3Registered
        assert user4Registered
        assert user5Registered
        assert user6Registered
        assert user7Registered

        when: "we start a booking process for events that is registered but fully booked"
        def user8Registered = bookingService.startBookingProcess(3, 8)
        def user9Registered = bookingService.startBookingProcess(6, 9)
        def user10Registered = bookingService.startBookingProcess(3, 10)
        def user11Registered = bookingService.startBookingProcess(3, 11)
        def user12Registered = bookingService.startBookingProcess(6, 12)
        def user13Registered = bookingService.startBookingProcess(3, 13)
        def user14Registered = bookingService.startBookingProcess(6, 14)
        def user15Registered = bookingService.startBookingProcess(6, 15)

        then: "users are not registered"
        assert !user8Registered
        assert !user9Registered
        assert !user10Registered
        assert !user11Registered
        assert !user12Registered
        assert !user13Registered
        assert !user14Registered
        assert !user15Registered
    }

    def "can accept new booking process after a booking is confirmed as unsuccessful"() {
        def repo = new Repo()
        repo.registerEventInAuditorium(5, 6, 2)
        repo.registerEventInAuditorium(7, 3, 5)

        when: "we start booking processes for events which are not fully booked"
        def bookingService = new BookingService(repo)
        def user1Registered = bookingService.startBookingProcess(6, 1)
        def user2Registered = bookingService.startBookingProcess(3, 2)
        def user3Registered = bookingService.startBookingProcess(6, 3)
        def user4Registered = bookingService.startBookingProcess(3, 4)
        def user5Registered = bookingService.startBookingProcess(3, 5)
        def user6Registered = bookingService.startBookingProcess(3, 6)
        def user7Registered = bookingService.startBookingProcess(3, 7)

        then: "users are registered"
        assert user1Registered
        assert user2Registered
        assert user3Registered
        assert user4Registered
        assert user5Registered
        assert user6Registered
        assert user7Registered

        when: "we start a booking process for events that is registered but fully booked"
        def user8Registered = bookingService.startBookingProcess(3, 8)
        def user9Registered = bookingService.startBookingProcess(6, 9)
        def user10Registered = bookingService.startBookingProcess(3, 10)
        def user11Registered = bookingService.startBookingProcess(3, 11)
        def user12Registered = bookingService.startBookingProcess(6, 12)

        then: "users are not registered"
        assert !user8Registered
        assert !user9Registered
        assert !user10Registered
        assert !user11Registered
        assert !user12Registered

        when: "some users confirm their booking as unsuccessful"
        def user1BookingConclusion = bookingService.confirmBookingStatus(6, 1, false)
        def user6BookingConclusion = bookingService.confirmBookingStatus(3, 6, false)
        def user2BookingConclusion = bookingService.confirmBookingStatus(3, 2, false)

        then: "bookings are confirmed as unsuccessful"
        assert !user1BookingConclusion.isSuccessful()
        assert user1BookingConclusion.auditoriumNumber() == 5
        assert !user6BookingConclusion.isSuccessful()
        assert user6BookingConclusion.auditoriumNumber() == 7
        assert !user2BookingConclusion.isSuccessful()
        assert user2BookingConclusion.auditoriumNumber() == 7

        when: "some users reattempt to start booking process"
        user8Registered = bookingService.startBookingProcess(3, 8)
        user9Registered = bookingService.startBookingProcess(6, 9)
        user10Registered = bookingService.startBookingProcess(3, 10)

        then: "users are registered after reattempt"
        assert user8Registered
        assert user9Registered
        assert user10Registered

        when: "remaining users reattempt to start booking process"
        user11Registered = bookingService.startBookingProcess(3, 11)
        user12Registered = bookingService.startBookingProcess(6, 12)

        then: "users are not registered after reattempt because the event is fully booked once again"
        assert !user11Registered
        assert !user12Registered
    }
}
