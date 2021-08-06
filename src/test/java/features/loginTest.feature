Feature: Application login

  Scenario: log in using valid credentials
    Given User is on the login page
    When user logs in with login "syst@email.com" and password "testtest123"
    Then Home page appears

    Scenario Outline: log in using invalid credentials
      Given User is on the login page
      When user logs in with login <Username> and password <Password>
      Then Error <message> appears
      Examples:
        | Username         | Password      | message                                  |
        | "ghghgh@gh1.com" | "testtest123" | "No customer account found"              |
        | "syst@email.com" | "test"        | "The credentials provided are incorrect" |
        | ""               | ""            | "No customer account found"              |


