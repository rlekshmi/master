@filter
Feature: Filter
  As an end user
  I want to apply filters
  So that I can find desired product


  @smoke @manual
  Scenario: Filter by review
    Given I am homepage
    When I search for product "nike"
    And I apply filter review "2or more"
    Then I should be able to see product rating "2"
    
  @smoke @filters

  Scenario: selecting a product through multiple filters
    Given I am homepage
    When I search for product "watch"
    And I select a category "Womens watches"
    Then I should be able to see title "Womens watches"
    When I apply filter brands "Sekonda"
    Then I should be able to see products with names"Sekonda"
    When I apply filter review "4or more"
    Then I should be able to see product rating "4"
    When I apply filter price "£20 - £25"
    Then I should be able to see product with prices greater than "20"
    And add a random product to trolley and go to trolley
    Then the trolley should contain product"Sekonda"


