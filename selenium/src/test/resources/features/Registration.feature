@Registration
Feature: Car Insurance User registration
    
    Background: 
    Given Launch browser and Navigate to URL
    
 @NewRegistration
  Scenario: Create the account with valid data by registering.
    When the user click on the registration link
    And create the new account
    Then new User profile should be created successfully
    
  @InvalidRegistration
     Scenario: Create an account with already registered username
         When the user click on the registration link
         And create account with the already registerd email address and password
         Then new User should not be created scucessfully  
    
    
    
