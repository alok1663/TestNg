package learning;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = "src/test/resources/", // Path to your feature files
    glue = "learning",                // Package containing step definitions
    plugin = {"pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json"},
    tags = "@Userlogin or @Userlogout",  
    monochrome = true  // To make console output more readable
)
public class Runner extends AbstractTestNGCucumberTests {
	
	
}
