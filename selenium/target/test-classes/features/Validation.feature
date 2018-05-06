@Validations
Feature: Validating all the webelements in Car details page
    
    Background: 
    Given Launch browser and Navigate to URL
    When the user click on the login link
    And enter valid UserName and Password
        
  @InvalidEntry 
  Scenario: Invalid License plate validation and years   
    When the user Enters invalid License plate 
    And enter non integer in cliam years
    Then user should be prompted with respective error messages
    
  @ValidEntry 
  Scenario: Verification of different license coverage advice
    When the user click enters valid license plate and years
    And Filling all the mandatory fields
    Then User should be able to check all the advices and proceed further
    
    
    
    
