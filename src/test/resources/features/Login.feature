@login
Feature:Login
  As user, I want to be able to login with username and password
#
#  Background: open login page
#    Given user is on the login page

  Scenario: Login as authorized user and verify that title is Account summary page
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user should verify that title is a Account summary page

  Scenario: Verify that an unauthorized user should not be able to login
    Given user is on the login page
    When user enters "abc" username and "xyz" password
    Then user will see error message "Login and/or password are wrong."

  Scenario: Verify that a user should not be able to login with empty username and password
    Given user is on the login page
    When user enters "" username and "" password
    Then user will see error message "Login and/or password are wrong."


