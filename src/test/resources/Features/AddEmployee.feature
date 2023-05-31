Feature: Employee

  Background:
    When user enters valid email and valid password
    And click on login button
    When user click on PIM option
    And user click on add employee button
@testcase2 @smoke
  Scenario: Adding a new Employee
    #Given open the browser and launch HRMS application
   # When user enters valid email and valid password
   # And click on login button
   # When user click on PIM option
    #And user click on add employee button
    And user enters firstname and middlename and lastname
    #And user clicks on save button
    #And close the browser
  @database
  Scenario: adding the employee from front end and verifying it from back end
    And user enters "nesha" and "sania" and "standart"
    And user captures the employee id
    And user clicks on save button
    And query the information in backend
    Then verify the results from frontend and backend