Feature: Login DTA5 - Forgot Password

  Background:
    Given I am on the homepage
    Given User navigates to the login page

  Scenario: TC9_Login - Validate user is able to use Forgot Password
    Given verify user is still on the login page
    When User clicks on the Forgot Password link
    Then User should see the Account recovery box