Feature: test

  Scenario: Search product
    Given I am on homepage
    When I search for product 'Samsung S10'
    Then verify all search result include 'Samsung'

  @wip
  Scenario: Add product to cart based on price
    Given I am on homepage
    When I search for product "product_name"
    And add <quantity> products to cart with price "<price>"
    Then Verify <quantity> products are present in cart

    Examples:
      | product_name | quantity | price |
      | Samsung S10  | 10       | 799   |