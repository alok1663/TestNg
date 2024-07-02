package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UiLogin {

  public static WebDriver driver;

  @BeforeAll
  public static void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--disable-gpu"); // optional but recommended
    options.addArguments("--window-size=1920,1080"); // optional but recommended
    options.addArguments("--no-sandbox"); // optional but recommended
    options.addArguments("--disable-dev-shm-usage"); // optional but recommended

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
  }

  @Given("the user is on the login page")
  public void the_user_is_on_the_login_page() {
    driver.get("https://www.saucedemo.com/");
    Assert.assertEquals(driver.getTitle(), "Swag Labs");
  }

  @When("the user enters valid credentials")
  public void the_user_enters_valid_credentials() {
    driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
    driver.findElement(By.xpath("//input[@id='login-button']")).click();
  }

  @Then("the user should be logged in successfully")
  public void the_user_should_be_logged_in_successfully() {  
    WebElement inventoryPageElement = driver.findElement(By.className("inventory_list"));
    WebElement titleElement = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Onesie']"));
    Assert.assertTrue(inventoryPageElement.isDisplayed(), "Login was not successful");
    Assert.assertTrue(titleElement.isDisplayed(), "Login Done");
  }
  
  @Given("the user is logged in")
  public void the_user_is_logged_in() {
    // Additional logic if needed
  }

  @When("the user clicks on the logout button")
  public void the_user_clicks_on_the_logout_button() throws InterruptedException {
    driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
    Thread.sleep(10000);
    driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
  }

  @Then("the user should be logged out successfully")
  public void the_user_should_be_logged_out_successfully() {
    WebElement LOGINBUTTON = driver.findElement(By.xpath("//input[@id='login-button']"));
    Assert.assertTrue(LOGINBUTTON.isDisplayed(), "Logout was not successful");
  }
  
  @AfterAll
  public static void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
