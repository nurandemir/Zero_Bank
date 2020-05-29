@purchase_currency
Feature: Purchase Foreign Currency
  Scenario: Available currencies
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And the user accesses the Purchase foreign currency cash tab
    Then following currencies should be available
      |Australia (dollar) |
      |Canada (dollar) |
      |Switzerland (franc) |
      |China (yuan) |
      |Denmark (krone) |
      |Eurozone (euro) |
      |Great Britain (pound)|
      |Japan (yen) |
      |Mexico (peso) |
      |Norway (krone) |
      |New Zealand (dollar) |
      |Singapore (dollar) |


    @notSelect_currency
  Scenario: Error message for not selecting currency
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

      @notEnter_value
  Scenario: Error message for not entering value
    Given user is on the login page
    When user enters "username" username and "password" password
    Then user clicks Pay Bills tab
    And the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without entering a value
    Then error message should be displayed