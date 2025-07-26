Feature: Add to Cart functionality on eBay

  @UITestcase
  Scenario: Successfully add a book to the cart
    Given I am on the eBay homepage
    When I search for "book"
    And I click on the first book in the search results
    And I click the Add to cart button
    Then the cart icon should show "1" item



#  @Testcase3
#  Scenario: Verify item details in the cart
#    Given I have added a book to the cart
#    When I view the cart
#    Then I should see the book name and price listed correctly
#  @Testcase3
#  Scenario: Cart updates with multiple added items
#    Given I am on the eBay homepage
#    When I search for "book"
#    And I click on the first book in the search results
#    And I go back to the search results
#    And I add the second book to the cart
#    Then the cart icon should show "2" item
#@Testcase4
  #Scenario: Add to cart button is disabled for out-of-stock items
    #Given I am on a book listing that is out of stock
    #Then the "Add to cart" button should be disabled or not visible
#@Testcase5
  #Scenario: Guest user adds a book to the cart
    #Given I am not signed in
    #When I search for "book" and add one to the cart
    #Then the cart icon should show "1" item
    #And I should not be forced to sign in
