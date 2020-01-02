Feature: Dogs Crud

  Scenario: Storing a new dog
    Given I create a dog named Speedy owned by Barak
    When I store the dog
    Then I can get Dog with Id 1 and verify it's the same dog
