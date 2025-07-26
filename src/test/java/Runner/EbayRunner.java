package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



	@CucumberOptions(features = "src/test/resources/Features", monochrome = true, glue = { "Steps"},
	plugin = {"pretty","html:target/report/cucumber.html","junit:target/report/cucumber.xml","json:target/report/cucumber-report.json"
					 }, 
	                   dryRun = false, publish = true, tags = "@UITestcase")

	public class EbayRunner extends AbstractTestNGCucumberTests   {
		
		
	

}
