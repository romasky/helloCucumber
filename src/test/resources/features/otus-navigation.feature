#language:en

  Feature: Validate Otus stream navigation
    Scenario: As a user a can navigate to Development stream page
      Given I navigate to Otus main page by 'https://otus.ru/'
      When I select tab 'Программирование'
      Then I should see 55 courses on 'Development' page