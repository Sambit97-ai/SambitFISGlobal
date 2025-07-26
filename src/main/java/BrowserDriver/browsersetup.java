 package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class browsersetup {

	public static WebDriver driver;
	
	public static WebDriver setup(String browsername, String url){
		 if (browsername.equalsIgnoreCase("chrome")) {
	            
	            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--remote-allow-origins=*");
	            options.addArguments("--disable-dev-shm-usage");
	            options.addArguments("--no-sandbox");

	            driver = new ChromeDriver();

		}else 
			if(browsername.equalsIgnoreCase("firefox")){
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
		}else 
			if(browsername.equalsIgnoreCase("ie")){
//				WebDriverManager.iedriver().setup();
//				driver = new InternetExplorerDriver();
			}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
