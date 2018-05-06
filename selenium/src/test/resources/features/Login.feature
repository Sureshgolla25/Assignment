@Login
Feature: Login with valid and invalid tests
    
    Background: 
    Given Launch browser and Navigate to URL
    
  @InvalidLogin
  Scenario: Login into car insurance with invalid username
    When the user click on the login link
    And enter invalid UserName and Password
    Then user should not login to site error message should be displayed
    
  @ValidLogin
  Scenario: Login into car insurance with valid username
    When the user click on the login link
    And enter valid UserName and Password
    Then user should login to site successfully
    
    
    
    
    
