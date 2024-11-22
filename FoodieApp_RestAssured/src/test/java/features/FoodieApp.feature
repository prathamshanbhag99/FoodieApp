Feature: Foodie API Testing
  This feature file tests the user, restaurant, and order-related functionalities of the Foodie API.

  Scenario: POST a customer user
    Given I have customer user details
    When I send a POST request to create a user
    Then I validate the user creation status code
    And I validate the created user ID

  Scenario: GET the created user by ID
    When I send a GET request to fetch the user by ID
    Then I validate the user details in the response

  Scenario: PUT to update the user name
    Given I have updated user details
    When I send a PUT request to update the user
    Then I validate the updated user name

  Scenario: POST a restaurant with admin login
    Given I have restaurant details
    And I log in as an admin
    When I send a POST request to create a restaurant
    Then I validate the created restaurant ID

  Scenario: POST an order with customer login
    Given I have order details
    When I send a POST request to create an order
    Then I validate the created order ID

  Scenario: GET all orders with admin login
    And I log in as an admin
    When I send a GET request to fetch all orders
    Then I validate the list of orders in the response

  Scenario: DELETE a user with admin login
    Given I log in as an admin
    And I have the user ID to delete
    When I send a DELETE request
    Then I validate the user deletion status code

