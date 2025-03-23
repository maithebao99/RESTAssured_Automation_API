@GetDetailBooking
Feature: Get data detail booking

  Scenario Outline: Receive data detail booking success when invoke get detail booking api
    Given Set body "<body>" to Add Booking API
    When Add a new booking when invoke api add booking
    Then Verify response data and <statusCode> Add Booking API
    Then Receive data detail booking when invoke api get detail booking
    And Verify response data detail booking and with status code is <statusCode>

    Examples:
      | body                      | statusCode |
      | fullValidData             | 200        |
      | firstnameEmptyString      | 200        |
      | lastnameEmptyString       | 200        |
      | totalpriceIs0             | 200        |
      | depositpaidFalse          | 200        |
      | addtionalneedsEmptyString | 200        |
      | addtionalneedsNull        | 200        |
