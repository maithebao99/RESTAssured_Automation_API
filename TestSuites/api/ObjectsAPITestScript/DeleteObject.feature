@RegressionTest
Feature: Delete object successfully

  @DeleteObject
  Scenario: Delete object success with id does exist when invoke api delete object
    Given Set body "HappyCase" to Add Object API
    When Create a new object when invoke api add object
    And Verify response data and body Add Object API
    When Object is deleted when invoke api delete object api with id does exist
    And Verify response data after invoke delete object api
    Then Receive data object when invoke api get object with id does exist
    And Verify response data and body Get Object API

  @DeleteObject
    Scenario: Show error when invoke delete object api with id doesn't exist
      Given Invoke api delete object api with id doesn't exist is "gw345t34v54tvb324t32b4v5t"
      When Verify response data after invoke delete object api
      Then Receive data object when invoke api get object with id doesn't exist is "gw345t34v54tvb324t32b4v5t"
      And Verify response data and body Get Object API