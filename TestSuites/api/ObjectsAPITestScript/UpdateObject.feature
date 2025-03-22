@RegressionTest @UpdateObject
Feature: Update object successfully

  @UpdateObject
  Scenario: Update data object success after create a object
    Given Set body "HappyCase" to Add Object API
    When Create a new object when invoke api add object
    And Verify response data and body Add Object API
    When Data of object is updated when invoke api update object
    And Verify response data is updated when invoke api update object