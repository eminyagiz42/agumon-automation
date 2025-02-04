Feature: DTA 01 Product Detail Page - Check the PDP informations

  Background:
    Given I am on the homepage
    Given User navigates to the login page
    Given verify user is still on the login page
    Given user enter the "standard-user" as username and "secret-sauce" as password and clicks sign in
    Given verify user is logged in


  Scenario: TC1_PDP Product Detail Page - The images of product is correctly shown
    Given user searches for a "ehsg" and then click search icon
    Then user is redirected to PLP page with searched results
    When user clicks on first item image on product listing page
    Then verify product images shown on product detail page


  Scenario: TC2_PDP Product Detail Page - The UOMs are correctly and fully show AND the user can change the UOM
    Given user searches for a "lb001" and then click search icon
    Then user is redirected to PLP page with searched results
    When user clicks on first item image on product listing page
    Then verify UOM menu is shown on product listing page
    And user changes UOM on product listing page
    Then verify UOM type is changed

  Scenario: TC3_PDP Product Detail Page - The hyperlinks of More info are focus to accordingly table when the user click on them
    Given user searches for a "kg104" and then click search icon
    Then user is redirected to PLP page with searched results
    When user clicks on first item image on product listing page
    Then verif user clicks on hyperlinks from More Info section and focus to accordingly table
      | Available Quantity |
      | On Order           |
      | Pricing            |

  Scenario: TC4_PDP Product Detail Page - Display exist options for itemType = Specific Lenght Lumber and Sheet Good
    Given user searches for a "ehsg" and then click search icon
    Then user is redirected to PLP page with searched results
    When user clicks on first item image on product listing page
