Feature: Login functionality


Scenario Outline: Login with valid credentials
Given User has navigated to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username                       |password|
|amotooricap12@gmail.com         |12345   |
|amotooricap2@gmail.com         |12345   |
|amotooricap3@gmail.com         |12345   |


Scenario: Login with invalid credentials
Given User has navigated to login page
When User enters invalid email address "amotooricap24@gmail.com" into email field
And User enters invalid password "123456789" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch


Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters invalid password "1234567" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch


Scenario: Login with invalid email and valid password
Given User has navigated to login page
When User enters invalid email address "amotooricap256@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch


Scenario: Login without providing any credentials
Given User has navigated to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch