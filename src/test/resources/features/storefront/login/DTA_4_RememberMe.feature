Feature: Login DTA4 - Remember Me

  Background:
    Given I am on the homepage
    Given User navigates to the login page

  Scenario: TC8_Login - Validate user is able to use Remember me feature
    Given verify user is still on the login page
    Given User enters credentials checks the Remember Me checkbox and logs in
    And User should log out successfully
    And username is remembered by the site and the user enters password presses the sign in button
