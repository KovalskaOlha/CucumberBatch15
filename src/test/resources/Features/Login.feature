Feature: Login Functionalities
@smoke
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully
    #And close the browser
  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    #And close the browser


  @scenarioOutline
  #Parameterization/ Data Driven
  Scenario Outline: Login with multiple credentials using Scenario Online
  #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully
    #And close the browser
  Examples:
  | username | password    |
  | admin    | Hum@nhrm123 |
  | ADMIN    | Hum@nhrm123 |
  | Jason    | Hum@nhrm123 |

  # data Table (also can used for the parameterization) but more functionality
  # than scenarioOutline
  # ONLY ONCE open the browser and close but the reason is Java code inside data table
  @dataTable
Scenario: login with multiple credentials using data table
  When user enters username and password and verifies login
    | username | password    |
    | admin    | Hum@nhrm123 |
    | ADMIN    | Hum@nhrm123 |
    | Jason    | Hum@nhrm123 |
@assertion
  Scenario Outline: Error message validation while invalid login
    When user enter "<Username>" and "<Password>"
    And click on login button
    Then user see "<ErrorMessage>"

    Examples:
      | Username | Password   | ErrorMessage             |
      | Admin    | Admin123   | Invalid credentials      |
      | Hello    | Syntax123! | Invalid credentials      |
      | Admin    |            | Password cannot be empty |
      |          | Syntax123! | Username cannot be empty |








  #HOOKS: for defining pre and post steps in any cucumber framework
  #     : This is always created inside StepDefinition folder
  #     : This class can not be inherited
  #     : Will take care of pre and post condition irrespective of what goes in between the test case
  # Parameterization (executing the same test case with multiple data)
  #Scenario Outline  rules
 # if you want to use parameteriztion
  #if you want to implement data driven testing
  # Scenarion Outline is always be used along with the keyword 'Examples'
