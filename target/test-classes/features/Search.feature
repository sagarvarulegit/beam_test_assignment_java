Feature: test
  @wip
  Scenario: Search product
    Given I am on homepage
    When I search for product 'Samsung S10'
    Then verify all search result include 'Samsung'