@account_activity
Feature:Account activity
  As user, I want to check the account activity page

  Scenario: Login and verify title: <title>
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Account Activity tab
    And user should verify that title is a Account activity page

  Scenario: Check account dropdown to have following options: Savings, Checking, Loan, Credit Card, Brokerage
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Account Activity tab
    And user should verify that account dropdown option "Savings" exist
    And user should verify that account dropdown option "Checking" exist
    And user should verify that account dropdown option "Loan" exist
    And user should verify that account dropdown option "Credit Card" exist
    And user should verify that account dropdown option "Brokerage" exist

  Scenario:Transactions table should have the following columns: Date, Description, Deposit, Withdrawal
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Account Activity tab
    And user should verify that transaction column name "Date" exist
    And user should verify that transaction column name "Description" exist
    And user should verify that transaction column name "Deposit" exist
    And user should verify that transaction column name "Withdrawal" exist
