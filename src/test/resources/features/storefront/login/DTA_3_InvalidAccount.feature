Feature: Login DTA3 - Invalid Account

  Background:
    Given I am on the homepage
    Given User navigates to the login page

  Scenario: TC4_Login - Login with an invalid account
    Given verify user is still on the login page
    Then user enters invalid username and password clicks sign in and error message displayed
      | username | password | message                                                                                     |
      | jhight   | 1234     | Your account has been disabled. Contact your system administrator for assistance. (ID# 974) |
    And verify user is still on the login page

  Scenario: TC5_Login - Login with an invalid account
    Given verify user is still on the login page
    Then user enters invalid username and password clicks sign in and error message displayed
      | username | password | message                                                     |
      | lbguest4 | A7878    | Invalid login. No customer access for this user. (ID# 6843) |
    And verify user is still on the login page

  @skip
  Scenario: TC6_Login - Login with an invalid account
    Given verify user is still on the login page
    Then user enters invalid username and password clicks sign in and error message displayed
      | username | password | message                                                                 |
      | xxxx     | xxxx     | User profile settings conflict. Please contact us to resolve the issue. |
    And verify user is still on the login page

  @skip
  Scenario: TC7_Login - Login with an invalid account
    Given verify user is still on the login page
    Then user enters invalid username and password clicks sign in and error message displayed
      | username | password | message                                                                                                                                                       |
      | lbguest4 | A7878    | Invalid login. The validation message displays "PartnerView / AGility Commerce Cloud is not set up for this USER ID (ID# 2683)" if ACC is not set up for user |
    And verify user is still on the login page