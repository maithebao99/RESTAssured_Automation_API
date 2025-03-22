@RegressionTest @AddBooking
Feature: Add booking successfully

  Scenario: Add booking successfully when invoke api add booking
    Given Set body "happycase" to Add Booking API
    When Add a new booking when invoke api add booking
    Then Verify response data and body Add Booking API