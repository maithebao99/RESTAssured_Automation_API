@RegressionTest
Feature: Get info object success

  @GetObject
  Scenario: Get object by id successfully
    Given Set body "HappyCase" to Add Object API
    When Invoke api add object
    And Verify response data and body request Add Object API
    Then Invoke api get object
    And Verify response data and body request Get Object API