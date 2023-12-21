#language:en

Feature: Validate Otus stream navigation

  Scenario Outline: As a user a can navigate to Development stream page
    Given I navigate to Otus main page by '<Url>'
    When I select tab '<tabName>'
    Then I should see <numberOfCourses> courses on "<tabName>" and tabName should be "<isTabVisible>" selected

    Examples:
      |Url              |    tabName             |       isTabVisible    | numberOfCourses |
      |https://otus.ru/ |    Безопасность        |       true            | 10              |
      |https://otus.ru/ |    Data Science        |       true            | 14              |
      |https://otus.ru/ |    Управление          |       true            | 20              |




  Scenario Outline: Create new user
    Given I navigate to Otus main page by '<Url>'
    When I click on the registration button
    Then I should see the open registration form
    When I enter '<name>' in the name field, '<surname>' in the surname field, '<email>' in the email field, and tap the registration button
    Then I should see '<numberOfNotifications>' notifications and the users 'name'

    Examples:
      | Url             | name       | surname     | email                    | numberOfNotifications |
      | https://otus.ru/ | John       | Doe         | john.doe@example.com    | 106                    |
      | https://otus.ru/ | Alice      | Smith       | alice.smith@example.com | 106                    |



