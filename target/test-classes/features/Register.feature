Feature: Registration functionality

@ignore
Scenario: User creates an account only with mandatory fields
Given User navigates to Registrater Account page
When User enters the details into below fields
|firstname  |Arun                 |
|lastname   |Motoori              |
|email      |amotoori241@gmail.com|
|telephone  |1234567890           |
|password   |12345                |
And User selects privacy policy
And User clicks on Continue button 
Then User account should get created successfully


@ignore
Scenario: User creates an account only with all fields
Given User navigates to Registrater Account page
When User enters the details into below fields
|firstname  |Arun                 |
|lastname   |Motoori              |
|email      |amotoori241@gmail.com|
|telephone  |1234567890           |
|password   |12345                |
And User selects yes for Newsletter
And User selects privacy policy
And User clicks on Continue button 
Then User account should get created successfully


@ignore
Scenario: User creates a duplicate account
Given User navigates to Registrater Account page
When User enters the details into below fields
|firstname  |Arun                 |
|lastname   |Motoori              |
|email      |amotoori241@gmail.com|
|telephone  |1234567890           |
|password   |12345                |
And User selects privacy policy
And User clicks on Continue button 
Then User should get a proper warning about duplicate email


@ignore
Scenario: User creates an account without filling any details
Given User navigates to Registrater Account page
When User dont enter any details into fields
And User clicks on Continue button
Then User should get a proper warning messages for every mandatory field
