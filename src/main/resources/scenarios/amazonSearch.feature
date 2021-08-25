@amazonWeb
Feature: Amazon Search

Background: open amazon on browser
  Given I open "https://www.amazon.in/" website

Scenario: search product in amazon
  Then I must see text "Select delivery location"
  And I wait "5" seconds for "amazon.web.search.input" to appear
  When I enter "New Apple iPhone 12 Mini 64gb - blue" to "amazon.web.search.input"
  And I click on "amazon.web.search.btn"
  Then I must see text "Results"
  And I should see "New Apple iPhone 12 Mini (64GB) - Blue" product in search result
  When I click on "New Apple iPhone 12 Mini (64GB) - Blue" product in search result
  Then I should see "New Apple iPhone 12 Mini (64GB) - Blue" header on detail screen
  When I scroll down to "amazon.web.addToCart.btn"
  And I wait for "2.0" seconds
  And I click on "amazon.web.addToCart.btn"
  Then I must see text "Subtotal"
  And I must see text "Proceed to Buy(1 item)"
  And I should see "New Apple iPhone 12 Mini (64GB) - Blue" product in cart