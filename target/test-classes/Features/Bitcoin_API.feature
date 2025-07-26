Feature: Bitcoin API validation

  @APITest1
  Scenario: Validate bitcoin data from CoinGecko
    Given the CoinGecko Bitcoin API is available
    When I send a GET request to fetch Bitcoin data
    Then the response status code should be 200
    And the response should contain USD, GBP and EUR in market data
    And each currency should have market cap and total volume
    And the 24h price change percentage should be present
    And the homepage URL should not be empty