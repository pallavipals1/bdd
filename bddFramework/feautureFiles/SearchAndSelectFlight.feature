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
@SearchFlight
Feature: Search Flight Feature
 

  @SearchAndSelectFlightTestV1
  Scenario: User can able to search and Select flight
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
    Then I take screen shot
    When i click logout
    Then i should see the login page again 
    And i close the browser
    
  @SearchAndSelectFlightTestV2
  Scenario Outline: User can able to search and Select flight-Multiple TestData Used
  	Given  open browser with url as "https://flights.qedgetech.com/"
    Then i should see login page
    When i enter user name and password as "interia@email.com" "Dsop@123"
    When i click sign in
    Then i should see user dashboard
    When I select flight date as "<Flight Date>"
    When I select flight from "<Flight From>"
    When I select flight to "<Flight To>"
    When I click Search Flight
    Then I Should see flight table
    When I select airline name as "<Airline Name>"
    Then i should see user dashboard
    Then I take screen shot
    When i click logout
    Then i should see the login page again 
    And i close the browser
  Examples:
					|Flight Date|Flight From|Flight To|Airline Name|
					|04/01/2025|Chennai|Kolkatha|Prasad Airlines|
					|04/05/2026|Hyderabad|Kolkatha|Soft Airlines|
					|04/25/2027|Hyderabad|Kolkatha|Air India|	
					
					
					