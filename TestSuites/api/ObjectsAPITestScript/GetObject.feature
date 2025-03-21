@RegressionTest
Feature: Get info object success

  @GetObject
  Scenario: Get object by id successfully
    Given Set body "HappyCase" to Add Object API
    When Create a new object when invoke api add object
    And Verify response data and body Add Object API
    Then Receive data object when invoke api get object with id valid
    And Verify response data and body Get Object API

  @GetObject
    Scenario: Get object by id invalid
      Then Receive data object when invoke api get object with id invalid is "thisidinvalid12345"
      And Verify response data and body Get Object API when invoke get object with id invalid