@BothTests
Feature: Check UI and API behavior

  @UITest
  Scenario: Validate Ebay Card behavior
    Given Navigate to ebay website
    When Search "book"
    When Click on first book in the list
    When Click on add to cart from item listing page
    Then Verify cart is has been updated and displays number of items
    And closeBrowser


  @APITest
  Scenario: Validate BPIs in response of CoinDesk API
    Given the API endpoint is "https://api.coindesk.com/v1/bpi/currentprice.json"
    When a GET request is sent to the endpoint
    Then the response status code should be "200"
    And the response should contain 3 BPIs:
      | BPI |
      | USD |
      | GBP |
      | EUR |
    And "GBP" description should equal "British Pound Sterling"



