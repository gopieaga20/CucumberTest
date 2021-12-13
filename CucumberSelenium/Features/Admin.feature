
Feature: Admin Menu

Background:
Given User launch the URL
When User enter credentials
|Admin|admin123|
And User login
Then Validate the user login

Scenario: Check Add user button is present in User Management screen
When Navigate to User Management
Then Verify Add user button

Scenario: Check User can navigate to Job title screen
When Navigate to Job title
Then Verify job title page