# Feature Name:
# User Story Name:
# User Story Number:
# Author:
# Description:
Feature: Verify the create user restful api endpoint New

Scenario: Create user by using restful api post endpoint
Given I specify the post restful api endpoint url
And I access given method to get RequestSpecification object
And I create user object using user pojo class
And I convert user object into user json object
And I provide header and body contents
When I access post http method to send request to server
Then I get status code as 201

Scenario: Display New Created User
Given I specify the get restful api endpoint url
And I access given method to get RequestSpecification object
When I access get http method to retrive resource from server
Then I validate content in response object
And I get status code as 200

Scenario: Delete New Created User
Given I specify the delete restful api endpoint url
And I access given method to get RequestSpecification object
When I access delete http method to delete resource from server
Then I get status code as 200

