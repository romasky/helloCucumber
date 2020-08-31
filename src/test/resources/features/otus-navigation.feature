#language:en

  Feature: Validate Otus stream navigation
    Scenario: As a user a can navigate to Development stream page
      Given I navigate to Otus main page by URL
      When I select tab Development
      Then I should see courses on Development page