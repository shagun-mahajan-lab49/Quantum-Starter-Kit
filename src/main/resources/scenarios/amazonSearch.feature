@amazonWeb
Feature: Amazon Search

Background: open amazon on browser
  Given I open webpage "https://www.amazon.in/" on browser

Scenario: search product in amazon
  Then I must see text "Select delivery location"
  And I wait "5" seconds for "//*[@id="nav-search-keywords"]" to appear
  When I enter "New Apple iPhone 12 Mini 64gb - blue" to "//*[@id="nav-search-keywords"]"
  And I click on "//*[@class="nav-search-submit"]"
  #When I scroll down
  Then I must see text "Results"
  And "//*[text()="New Apple iPhone 12 Mini (64GB) - Blue"]" must exist
  When I click on "//*[text()="New Apple iPhone 12 Mini (64GB) - Blue"]"
  And "//h1[contains(.,"New Apple iPhone 12 Mini (64GB) - Blue")]" must exist
  And I must see text "In Stock"
  When I scroll down
  And I click on "//*[@id="a-autoid-2"]//*[@class="a-button-inner"]"
  Then I wait "3" seconds to see the text "Subtotal"
  Then I must see text "Subtotal"
  And I must see text "Proceed to Buy(1 item)"
  And "//*[@id="sc-active-cart" and contains(.,"New Apple iPhone 12 Mini (64GB) - Blue")]" must exist