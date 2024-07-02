//STEP DEFINITION FILE

package learning;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeOptions;

public class UILoginEdge {

  public static  WebDriver driver;

   @BeforeTest
    public void the_user_is_on_the_login_page() {
	   WebDriverManager.edgedriver().setup();
	    EdgeOptions options = new EdgeOptions();
	    options.addArguments("--headless");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");
        
		Assert.assertEquals(driver.getTitle(), "Swag Labs");	
    }

   @Test(priority = 1)
    public void the_user_enters_valid_credentials() {
    
    	
    	driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
    	driver.findElement(By.xpath("//input[@id='login-button']")).click();

  

    }

   @Test(priority = 2)
    public void the_user_should_be_logged_in_successfully() {  
        WebElement inventoryPageElement = driver.findElement(By.className("inventory_list"));
        WebElement titleElement = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Onesie']"));
    	  Assert.assertTrue(inventoryPageElement.isDisplayed(), "Login was not successful");
    	  Assert.assertTrue(titleElement.isDisplayed(), "Login Done");
    	
    	
     
    }
    
   @Test(priority = 3)
    public void the_user_is_logged_in() {
   //     the_user_is_on_the_login_page();
     //   the_user_enters_valid_credentials();
    //    the_user_should_be_logged_in_successfully();
    }
   @Test(priority = 4)
    public void the_user_clicks_on_the_logout_button() throws InterruptedException {
      
    	driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
    	Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
       
    }

   @Test(priority = 5)
    public void the_user_should_be_logged_out_successfully() {
      
    	WebElement LOGINBUTTON = driver.findElement(By.xpath("//input[@id='login-button']"));

    	Assert.assertTrue(LOGINBUTTON.isDisplayed(), "Logout was not successful");
    	
    	
     
       driver.quit();
       

    }
}
