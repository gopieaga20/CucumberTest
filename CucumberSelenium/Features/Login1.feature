Feature: Login

Scenario Outline: Verify user login 
Given User launch the URL
When User enter credentials "<username>" and "<password>"
And User login
Then Validate the user login

Examples:
|username|password|
|Admin|admin123|
|Admin|admin234|
|Admin|admin123|










