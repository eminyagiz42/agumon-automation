Feature: DTA 02 Login - With an valid account

  Background:
    Given I am on the homepage
    Given User navigates to the login page

  Scenario: TC2_Login - User can login by all accounts exist on the system
    Given verify user is still on the login page
    When User enter the login details and clicks sign in
    Then Verify user name same with in the account menu
    And User should log out successfully

  Scenario: TC3_Login - User redirect to login page
    Given verify user is still on the login page
    When User enter the login details and clicks sign in
    Then verify user is still on the login page

