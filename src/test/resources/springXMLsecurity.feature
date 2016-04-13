Feature: springXMLsecurity.feature

  Scenario: Register security service
    Given I am on the start page
    And User name is "user"
    And Password is "password"
    When I performs operation "get"
    Then I see "Welcome!" in response
