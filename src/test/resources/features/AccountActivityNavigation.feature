@activity_navigation
Feature: Navigating to specific accounts in Accounts Activity

  Scenario: Savings account redirect
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks "Savings" account link
    And user should verify that title is a Account activity page
    And user verifies "Savings" is selected in dropdown

  Scenario: Brokerage account redirect
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks "Brokerage" account link
    And user should verify that title is a Account activity page
    And user verifies "Brokerage" is selected in dropdown

  Scenario: Checking account redirect
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks "Checking" account link
    And user should verify that title is a Account activity page
    And user verifies "Checking" is selected in dropdown

  Scenario: Credit Card account redirect
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks "Credit Card" account link
    And user should verify that title is a Account activity page
    And user verifies "Credit Card" is selected in dropdown

  Scenario: Loan account redirect
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks "Loan" account link
    And user should verify that title is a Account activity page
    And user verifies "Loan" is selected in dropdown