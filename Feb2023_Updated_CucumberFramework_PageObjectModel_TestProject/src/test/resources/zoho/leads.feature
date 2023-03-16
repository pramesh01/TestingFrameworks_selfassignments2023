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
@ManagingLeads
Feature: Managing the leads of my project
  I want to create and delete the leads on my website
  
   Background: logged in to application
             Given i am logging into website https://zoho.com
             And i click on 'leads' tab on top menu
             
  @CreateLeads
  Scenario Outline: Creating the Leads inside Application
    When i goto 'create the lead' page
    And enter and submit the lead details
    And i goto the 'lead details' page 
    Then i verify the lead details
    #When i click on 'leads' tab on top menu
    And lead should be present inside the grid
    
     Examples: 
      | firstname  | lastname | emailid              | company  |
      | riyab      | jacobs   | rjacobs@hotmail.com  | microsoft|
   
  @DeleteLead
  Scenario Outline: Deletion of the lead
        When I select the lead 
        And I click on delete button
        Then Lead should be deleted
  
    
