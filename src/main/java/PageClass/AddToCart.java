package PageClass;

import BrowserDriver.browsersetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import PageObjects.HomePageObjects;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
//import org.junit.Assert;

public class AddToCart extends browsersetup {
	
	

	 WebDriver driver;

	 HomePageObjects hp=new HomePageObjects();
	
	public AddToCart(WebDriver driver) {
		this.driver = driver;

	}
	String originalWindow;
	
	public void LaunchHomepage()throws Exception
	{
		String CurrentUrl=driver.getCurrentUrl();
		if(CurrentUrl.equals("https://www.ebay.com/")){
			System.out.println("user is in homepage");
		}
		else{
			System.err.println("user is not in homepage");
			//Assert.assertFail("user is not in homepage");
		}

		
	}
	public void ClickSearch(String Keyword)throws Exception{
		try {
			driver.findElement(By.xpath(hp.SearchBox)).click();
			System.out.println("User Click on search box ");
			driver.findElement(By.xpath(hp.SearchBox)).sendKeys(Keyword);
			System.out.println("User click on serach button ");
			driver.findElement(By.xpath(hp.SearchButton)).click();
		}
		catch(Exception e) {
			System.out.println("Unable to click on Item");
		}
	}

	public void ClickonIteem(WebDriver driver)throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			List<WebElement> products  = wait.until(
					ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul//div[@class='s-card__title']")));
			//List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/li"));
			originalWindow = driver.getWindowHandle();
			// Click the first element if the list is not empty
			if (!products.isEmpty()) {
				WebElement itemToClick = products.get(0);

				// Scroll into view and click using JavaScript
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", itemToClick);

				System.out.println("Clicked on item 1 using JavaScriptExecutor.");

				Set<String> windowHandles = driver.getWindowHandles();

				// Switch to the new tab (the one that's not the original)
				for (String handle : windowHandles) {
					if (!handle.equals(originalWindow)) {
						driver.switchTo().window(handle);
						break;
					}
				}
			}
		}catch(Exception e) {
			System.err.println("No elements found.");
		}
		
	}
	public void VerifyAddtoCart(WebDriver driver)throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement addToCartButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(hp.AddtoCartBtn))
			);
			addToCartButton.click();
			System.out.println("Add to cart clicked.");
		} catch (Exception e) {
			System.err.println("Add to cart button not found or not clickable.");
		}
		
	}
public void SeeOnCart(String item)throws Exception
{
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement seeInCartButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(hp.SeeinCart))
		);
		seeInCartButton.click();
		System.out.println("See in Cart clicked.");
		driver.switchTo().window(originalWindow);
		driver.navigate().refresh();
		Thread.sleep(2000);
		String Itemcount=driver.findElement(By.xpath(hp.CartIconCount)).getText();
		if(Itemcount.equals(item)){
			System.out.println("One Item is added to cart.");
		}
	} catch (Exception e) {
		System.err.println("See in Cart button not found.");
	}
}



	
	
}
