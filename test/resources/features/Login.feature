@login @regression

Feature: WebDriver University - Login Page

  Background:
    Given I access the webdriver university login page


  Scenario: Validate Successful Login
    When I enter a username webdriver
    And I enter a password webdriver123
    And I click on login button
    Then I should be presented with the successful login message


  Scenario: Validate Unsuccessful Login
    When I enter a username webdriver
    And I enter a password webdriver1
    And I click on login button
    Then I should be presented with the unsuccessful login message

  @smoke
  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click on login button
    Then I should be presented with following login validations message <loginValidationMessage>

    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | webdriver1   | validation failed      |
      | joeblogs  | password1    | validation failed      |
