Feature: User Registration
  i want to check user can register in e-commerce website

  Scenario Outline: User Registration
    Given The user in home page
    When i click on register link
    And i entered data user "<firstname>" ,"<lastname>" ,"<email>" ,"<password>"
    Then the page of registration displayed successfully

    Examples:
      | firstname | lastname    | email                | password  |
      | ahmeddd   | abpkhadraaa | abdallah01@gmail.com | 47855444  |
      | alia      | saeedd      | abdallah02@gmail.com | 984557144 |