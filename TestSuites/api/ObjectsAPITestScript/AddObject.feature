@RegressionTest
Feature: Add a object

  @PositiveTest @AddObject
  Scenario: Add a object successfully when invoke api add object with full field json body
    Given Set body "HappyCase" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body request Add Object API

  @NegativeTest
  Scenario: Add a object successfully when invoke api add object with json body missing name
    Given Set body "MissingName" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body request Add Object API

  @NegativeTest
  Scenario: Add a object successfully when invoke api add object with json body missing data object
    Given Set body "MissingData" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body request Add Object API

  @NegativeTest
  Scenario: Add a object successfully when invoke api add object with json body missing year
    Given Set body "MissingYear" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body request Add Object API

  @NegativeTest
  Scenario: Add a object successfully when invoke api add object with json body missing price
    Given Set body "MissingPrice" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body request Add Object API

  @NegativeTest
  Scenario: Add a object successfully when invoke api add object with json body missing CPU Model
    Given Set body "MissingCPUModel" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body request Add Object API

  @NegativeTest
  Scenario: Add a object successfully when invoke api add object with json body missing Hard Disk Size
    Given Set body "MissingHardDiskSize" to Add Object API
    When Create a new object when invoke api add object
    Then Verify response data and body request Add Object API