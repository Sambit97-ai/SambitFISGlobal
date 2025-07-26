package Steps;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.junit.Assert;

import java.util.Map;

public class BitCoin_APIStepdef {






        private Response response;

        @Given("the CoinGecko Bitcoin API is available")
        public void the_api_is_available() {
            RestAssured.baseURI = "https://api.coingecko.com/api/v3/coins/bitcoin";
        }

        @When("I send a GET request to fetch Bitcoin data")
        public void i_send_get_request() {
            response = RestAssured
                    .given()
                    .when()
                    .get()
                    .then()
                    .extract()
                    .response();
        }

        @Then("the response status code should be {int}")
        public void validate_status_code(int statusCode) {
            int statuscode = response.getStatusCode();
            Assert.assertEquals(statusCode, response.getStatusCode());
        }

        @Then("the response should contain USD, GBP and EUR in market data")
        public void validate_currencies_present() {
            Map<String, ?> currentPrice = response.jsonPath().getMap("market_data.current_price");

            Assert.assertTrue("USD not found", currentPrice.containsKey("usd"));
            Assert.assertTrue("GBP not found", currentPrice.containsKey("gbp"));
            Assert.assertTrue("EUR not found", currentPrice.containsKey("eur"));
        }

        @Then("each currency should have market cap and total volume")
        public void validate_market_cap_and_volume() {
            Map<String, ?> marketCaps = response.jsonPath().getMap("market_data.market_cap");
            Map<String, ?> totalVolumes = response.jsonPath().getMap("market_data.total_volume");

            for (String currency : new String[]{"usd", "gbp", "eur"}) {
                Assert.assertTrue("Market cap missing for " + currency, marketCaps.containsKey(currency));
                Assert.assertTrue("Total volume missing for " + currency, totalVolumes.containsKey(currency));
            }
        }

        @Then("the 24h price change percentage should be present")
        public void validate_price_change_percentage() {
            Float change = response.jsonPath().getFloat("market_data.price_change_percentage_24h");
            Assert.assertNotNull("24h price change percentage is missing", change);
        }

        @Then("the homepage URL should not be empty")
        public void validate_homepage_url() {
            String homepage = response.jsonPath().getString("links.homepage[0]");
            Assert.assertNotNull("Homepage URL is null", homepage);
            Assert.assertFalse("Homepage URL is empty", homepage.trim().isEmpty());
        }
    }


