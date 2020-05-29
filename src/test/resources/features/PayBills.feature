@payBills
Feature:Pay bills
  As user, I want to complete a pay operation

  Scenario: Login and verify title: <title>
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And user should verify that title is Zero - Pay Bills

  Scenario: Complete a successful Pay operation
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And user should verify that "The payment was successfully submitted." should be displayed

  @without_amount
  Scenario: Try an unsuccessful Pay operation without entering amount
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And user should verify that "Please fill out this field." should be displayed when without entering amount

  @without_date
  Scenario: Try an unsuccessful Pay operation without entering date
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And user should verify that "Please fill out this field." should be displayed when without entering date

  @alphabetical_char
  Scenario:Amount field should not accept alphabetical character
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And user should verify that alphabetical character should not be accepted as amount

    @specialChar_amount
  Scenario:Amount field should not accept any special character
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And user should verify that special character should not be accepted as amount


  Scenario:Date field should not accept any special character
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And user should verify that special character should not be accepted as date

  @test_this_scenario
  Scenario:Date field should not accept any special character
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And user should verify that alphabetical character should not be accepted as date