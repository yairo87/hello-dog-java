Feature: Application basic functionality

  Scenario: Service is up
    Then I get UP response from healthcheck

  Scenario: Swagger API exposed
    Then I get API doc from API
