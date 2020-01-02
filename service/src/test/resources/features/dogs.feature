Feature: Dogs Crud

  Scenario: Storing a new dog
    Given I create a dog named Speedy owned by Barak
    When I store the dog
    Then I can get the Dog with the id I got from POST and verify it's the same dog

  Scenario: Deleting a dog
    Given I create a dog named Speedy owned by Barak
    When I store the dog
    And I delete the dog
    Then I won't be able to get the Dog with the id I got from POST
