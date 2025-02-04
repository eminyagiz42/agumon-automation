Feature: DTA 1 Catalog

  Background:
    Given I am on the homepage
    Given user enter the "standard_user" as username and "secret_sauce" as password and clicks sign in
    When verify user is logged in


  Scenario: TC2_Catalog Check the Category link directs user to the Category PLP
    Then the user is landed on the category PLP