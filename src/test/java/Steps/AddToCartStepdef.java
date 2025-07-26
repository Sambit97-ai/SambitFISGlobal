package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageClass.AddToCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.FileInputStream;
import java.util.Properties;

import BrowserDriver.browsersetup;


public class AddToCartStepdef extends browsersetup {
	
	//WebDriver driver;
	AddToCart Ac=new AddToCart(driver);
	
	
	@Given("I am on the eBay homepage")
	public void i_am_on_the_e_bay_homepage()throws Exception {
		Ac.LaunchHomepage();
	    
	}

	@When("I search for {string}")
	public void i_search_for(String book)throws Exception {
	    Ac.ClickSearch(book);
	}

	@When("I click on the first book in the search results")
	public void i_click_on_the_first_book_in_the_search_results()throws Exception {
	    Ac.ClickonIteem(driver);
	}

	@When("I click the Add to cart button")
	public void i_click_the_button()throws Exception {
	    
	    Ac.VerifyAddtoCart(driver);
	}

	@Then("the cart icon should show {string} item")
	public void the_cart_icon_should_show_item(String item)throws Exception {
	    Ac.SeeOnCart(item);
	   
	}


}
