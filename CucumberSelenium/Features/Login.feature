Feature: Login

Scenario: User login with Valid data
Given User launch the URL
When User enter credentials
|Admin|admin123|
And User login
Then Validate the user login

@login
Scenario: User login with Valid data
Given User launch the URL
When User enter credentials1
And User login
Then Validate the user login


