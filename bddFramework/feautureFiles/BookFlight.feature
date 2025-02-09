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
@BookFlight
Feature: Book Flight feature
  

  @BookFlightTest1
  Scenario: user is able to book the flight
    Given  open browser with url as "https://flights.qedgetech.com/"
    Then i should see login page
    When i enter user name and password as "interia@email.com" "Dsop@123"
    When i click sign in
    Then i should see user dashboard
    When I select flight date as "07/16/2025"
    When I select flight from "Hyderabad"
    When I select flight to "Kolkatha"
    When I click Search Flight
    Then I Should see flight table
    When I select airline name as "King Fisher Airlines"
    Then i should see user dashboard
    When i enter the name as "abhishek"
    When i select class 
    When i click insert order
    When i click logout
    Then i should see the login page again 
    When i close the browser

  @BookFlightTest2
  Scenario: user is able to book the flight
    Given  open browser with url as "https://flights.qedgetech.com/"
    Then i should see login page
    When i enter user name and password as "interia@email.com" "Dsop@123"
    When i click sign in
    Then i should see user dashboard
    When I select flight date as "07/16/2025"
    When I select flight from "Hyderabad"
    When I select flight to "Kolkatha"
    When I click Search Flight
    Then I Should see flight table
    When I select airline name as "King Fisher Airlines"
    Then i should see user dashboard
    When i enter the name as "<Name>"
    When i select class
    When i click insert order
    When i click logout
    Then i should see the login page again 
    When i close the browse

    Examples: 
      | Name  |
      | adi |
      | arya |
