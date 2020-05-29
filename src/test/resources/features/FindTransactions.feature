@transactions
Feature:Find Transactions in Account Activity

  Scenario:Search date range
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Account Activity tab
    And the user accesses the Find Transactions tab
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should not contain transactions dated "2012-09-01"

  @contain_office
  Scenario: Search description
      Given user is on the login page
      When user enters "username" username and "password" password
      Then user clicks Account Activity tab
      And the user accesses the Find Transactions tab
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And clicks search
    Then results table should only show descriptions containing "OFFICE"
    #But results table should not show descriptions containing "OFFICE"


  @contain_online
  Scenario: Search description case insensitive
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Account Activity tab
    And the user accesses the Find Transactions tab
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "online"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    And verify that uppercase and lowercase results are same

    @contain_type
  Scenario: Type
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Account Activity tab
    And the user accesses the Find Transactions tab
    And clicks search
    Then results table should show at least one result under Deposit
    Then results table should show at least one result under Withdrawal
    When user selects type "Deposit"
    Then results table should show at least one result under Deposit
    But results table should show no result under Withdrawal
    When user selects type "Withdrawal"
    Then results table should show at least one result under Withdrawal
    But results table should show no result under Deposit
