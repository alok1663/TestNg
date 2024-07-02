Feature: Login functionality

@Userlogin
Scenario: Successful login
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be logged in successfully

@Userlogout
Scenario: Logout
    Given the user is logged in
    When the user clicks on the logout button
    Then the user should be logged out successfully
