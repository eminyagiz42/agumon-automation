Feature: DTA 06 Login - Request an account page

  Background:
    Given I am on the homepage
    Given User navigates to the login page

  Scenario: TC10_Login - Validate user is able to Request an account
    Given verify user is still on the login page
    When User clicks on Request an account link
    Then User fills all fields in Request an account form and submit the request
    Then  Approval message should display
      | message |
      | Your request has been sent to our office for review. Thank you |