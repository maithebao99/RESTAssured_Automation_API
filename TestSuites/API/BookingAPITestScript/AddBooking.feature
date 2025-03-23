@RegressionTest @AddBooking
Feature: Add booking successfully

  Scenario Outline: Add booking when invoke api add booking
    Given Set body "<body>" to Add Booking API
    When Add a new booking when invoke api add booking
    Then Verify response data and <statusCode> Add Booking API
    Examples:
      | body                      | statusCode |
      | fullValidData             | 200        |
      | firstnameEmptyString      | 200        |
      | firstnameNull             | 500        |
      | lastnameNull              | 500        |
      | lastnameEmptyString       | 200        |
      | totalpriceIs0             | 200        |
      | totalpriceNull            | 500        |
      | depositpaidFalse          | 200        |
      | depositpaidNull           | 500        |
      | bookingdatesNull          | 500        |
      | checkinNull               | 500        |
      | checkoutNull              | 500        |
      | addtionalneedsEmptyString | 200        |
      | addtionalneedsNull        | 200        |
      | bodyEmpty                 | 500        |
