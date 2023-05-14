Feature: DemoQA- checkbox

  Scenario: User should be able to select public and private
    Given I navigate to "https://demoqa.com/checkbox"
    When I select public and private
    Then I should see "You have selected : public private"
    And I quit the browser


