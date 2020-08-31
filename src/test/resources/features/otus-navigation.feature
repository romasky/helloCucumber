#language:en

Feature: Validate Otus stream navigation

  Scenario Outline: As a user a can navigate to Development stream page
    Given I navigate to Otus main page by 'https://otus.ru/'
    When I select tab '<tabName>'
    Then I should see <numberOfCourses> courses on '<tabName>' page
    Examples:
      | tabName                     | numberOfCourses |
      | Информационная безопасность | 6               |
      | Data Science                | 10              |
      | Управление                  | 7               |