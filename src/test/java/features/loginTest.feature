Feature: Application login

  Scenario: log in using valid credentials
    Given User is on the login page - verify "Welcome, Please Sign In!" displayed on the page
    When user enter valid credentials and clicks on the Login button
    Then Home page appears

  Scenario: log in using invalid email and valid pwd
     Given User is on the login page - verify "Welcome, Please Sign In!" displayed on the page
     When user enters invalid email and valid pwd and clicks on the Login button
     Then error message "No customer account found" appears

  Scenario: log in using valid email and invalid pwd
     Given User is on the login page - verify "Welcome, Please Sign In!" displayed on the page
     When user enters valid email and invalid pwd and clicks on the Login button
     Then the error message "The credentials provided are incorrect" appears

  Scenario: log in with email and password fields blank
    Given User is on the login page - verify "Welcome, Please Sign In!" displayed on the page
    When user leaves email and pwd fields blank and clicks on the Login button
    Then error message "No customer account found" appears

