#Author: 
#Scenario:
#Feature Name:
# Feature ID/UserStory ID:
@Execute
Feature: Verify Create User Functionality.
Description: CreateUser--> DisplayUser--> DeleteUser
Scenario: Verify Create,Display and Delete User Steps
Given I provide createUser endpoint
And I get the RequestSpecification referece object
And I create request json object
And I assign pojo object to request
When I post the request
Then I get the 201 status code
And I get the newly created user user_id
Given I provide displayUser endpoint
And I get the RequestSpecification referece object
When i get the user response from the server
Then I get the 200 status code
Given I provide deleteUser endpoint
And I get the RequestSpecification referece object
When I delete the user from the server
Then I get the 200 status code