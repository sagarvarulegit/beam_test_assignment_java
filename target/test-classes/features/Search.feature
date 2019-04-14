Feature: test

  Scenario: Search product
    Given I am on homepage
    When I search for product 'Samsung S10'
    Then verify all search result include 'Samsung'

  @wip
  Scenario Outline: Add product to cart based on price
    Given I am on homepage
    When I search for product "<product_name>"
    And add "<quantity>" products to cart with price "<price>"
    Then Verify total price "<price>"
    Then Verify "<quantity>" products are present in cart
    And Verify "<product_name>" is in the cart
    When I change "<increase_quantity>" in view cart page
    Then Verify total price "<increase_price>"

    Examples:
      | product_name       | quantity | price | increase_quantity | increase_price |
      | Samsung Galaxy S10 | 1        | 1,149 | 9                 | 10,349     |