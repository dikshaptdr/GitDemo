Feature: Login into application

Scenario Outline: Positive test validation login
Given Initialise the browser with chrome
And Navigate to "https://qaclickacademy.com" site
And Click on login link in home page to land on Secure Signin Page
When user enters <Username> and <Password> and logs in
Then Verify that user is successfully logged in
And Close Browsers

Examples:
|Username			|Password	|
|test99@gmail.com	|123456		|
|test12@gmail.com	|7890		|