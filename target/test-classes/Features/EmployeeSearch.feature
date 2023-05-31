Feature: Searching the employee

  Background:
    When user enters valid email and valid password
    And click on login button
    When user click on PIM option

  @smoke1
  Scenario: Search employee by ID
    # Given open the browser and launch HRMS application
    # When user enters valid email and valid password
    # And click on login button
    # When user click on PIM option
    When user enters valid employee id
    And clicks on search button
    And user see employee information displayed
    #And close the browser
    @smoke1
    Scenario: Search employee by job title
      # Given open the browser and launch HRMS application
      # When user enters valid email and valid password
      # And click on login button
      # When user click on PIM option
      When user select job title
      And clicks on search button
      And user see employee information displayed
      #And close the browser






  # Background : this is used to define all common steps that multiple
  #            :scenarious have in the same feature file till the time flow is not broken
  #How can we get data?
  # 1. Hard code(Java)
  # 2. Config file(Java)
  # 3. Regular expressions in "..."(Cucumber itself provides options )
  # 4. Scenarion Outline (provides an alternative to Data Driven Testing)
     # also supports parametrization


