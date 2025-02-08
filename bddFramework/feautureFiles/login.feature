#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@login
Feature: login feature
 

  @loginTest
  Scenario: user can login with valid credentials
    Given  open browser with url as "https://flights.qedgetech.com/"
    Then i should see login page
    When i enter user name and password as "interia@email.com" "Dsop@123"
    When i click sign in
    Then i should see user dashboard
    When i click logout 
    Then i should see the login page again 
    And i close the browser
    
   @loginTest2
    Scenario Outline: user can login with valid credentials
   	Given  open browser with url as "https://flights.qedgetech.com/"
    Then i should see login page
    When i enter user name and password as "<userName>" "<pwd>"
    When i click sign in
    Then i should see error Message
    And i close the browser
    Examples:
    				|userName|pwd|
    				|interias@email.com|Dsop@123|
    				|interias1@email.com|Dsop2@123|
    