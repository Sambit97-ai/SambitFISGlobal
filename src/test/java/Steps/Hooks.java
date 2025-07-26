package Steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import BrowserDriver.browsersetup;
import PageClass.AddToCart;
import io.cucumber.java.After;
import io.cucumber.java.Before;


 public class Hooks extends browsersetup {
	 AddToCart ad;
	static String configfilepath = System.getProperty("user.dir") + "//config//file.properties";
	static Properties prop;
	static FileInputStream fileInput;

	public static void Configuration() {
		try {
			fileInput = new FileInputStream(configfilepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
	
	}
	}

	@Before("@UITestcase")
	public void setUp() throws InterruptedException {
		System.out.println("Open browser");
		Configuration();		
		driver = browsersetup.setup(prop.getProperty("browsername"), prop.getProperty("url"));
		
	    Thread.sleep(1000);
	}

	@After
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			System.out.println("Close browser  ");
			driver.quit();
			driver = null;
		} else {
			System.out.println("No browser to close (API test or browser not launched).");
		}
	}
}
