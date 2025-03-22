@RegressionTest @AddObject
Feature: Add a object successfully

  @PositiveTest
  Scenario: Add a object successfully when invoke api add object with full field json body
    Given Set body "HappyCase" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body Add Object API

  @NegativeTest
  Scenario: Add a object successfully with value name is null when invoke api add object with json body missing name
    Given Set body "MissingName" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body Add Object API

  @NegativeTest
  Scenario: Add a object successfully with value data is null when invoke api add object with json body missing data object
    Given Set body "MissingData" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body Add Object API

  @NegativeTest
  Scenario: Add a object successfully when invoke api add object with value data random key-value
    Given Set body "ValueDataRandomKey" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body Add Object API