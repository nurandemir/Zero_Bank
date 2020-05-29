@account_summary
Feature:Account summary
  As user, I want to see account summary

  Scenario: Login and verify title: <title>
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user should verify that title is a Account summary page

  Scenario: Account summary page should have the following account types:Cash Accounts, Investment Accounts, Credit
  Accounts, Loan accounts
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user should verify that account type "Cash Accounts" exist
    Then user should verify that account type "Investment Accounts" exist
    Then user should verify that account type "Credit Accounts" exist
    Then user should verify that account type "Loan Accounts" exist


  Scenario: Credit Accounts table must have the following columns: Account, Credit Card, Balance
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user should verify that column name "Account" exist
    Then user should verify that column name "Credit Card" exist
    Then user should verify that column name "Balance" exist