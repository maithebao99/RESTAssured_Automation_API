@RegressionTest @Object
Feature: Get info object successfully

  @GetObject
  Scenario: Get object by id does exist
    Given Set body "HappyCase" to Add Object API
    When Create a new object when invoke api add object
    And Verify response data and body Add Object API
    Then Receive data object when invoke api get object with id does exist
    And Verify response data and body Get Object API

  @GetObject
    Scenario: Get object by id doesn't exist
      Then Receive data object when invoke api get object with id doesn't exist is "thisidinvalid12345"
      And Verify response data and body Get Object API

  @GetObject
  Scenario: Get object by id doesn't exist
    Then Receive data object when invoke api get object with id doesn't exist is ""
    And Verify response data and body Get Object API