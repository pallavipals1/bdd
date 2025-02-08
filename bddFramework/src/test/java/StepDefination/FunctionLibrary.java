package StepDefination;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FunctionLibrary {
	public static WebDriver driver;
	@Given("open browser with url as {string}")
	public void open_browser_with_url_as(String url) {
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.get(url);
	}
	@Then("i should see login page")
	public void i_should_see_login_page() {
		
	  WebElement login = driver.findElement(By.className("login-box-msg"));
	  if(login.isDisplayed()) {
	  System.out.println(login.getText());
	  }
	}
	@When("i enter user name and password as {string} {string}")
	public void i_enter_user_name_and_password_as(String emailId, String pass) {
	   driver.findElement(By.name("email")).sendKeys(emailId);
	   driver.findElement(By.name("password")).sendKeys(pass);
	}
	@When("i click sign in")
	public void i_click_sign_in() {
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("i should see user dashboard")
	public void i_should_see_user_dashboard() {
	    WebElement dashElement = driver.findElement(By.xpath("//div[contains(@class,'banner-inner')]/h2"));
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOf(dashElement));
	    if(dashElement.isDisplayed()) {
	    	System.out.println(dashElement.getText());
	    }
	}
	@When("i click logout")
	public void i_click_logout() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'account-menu-dropdown')]/a/i")));
	    act.click().build().perform();
		driver.findElement(By.linkText("Logout")).click();
	}
	@Then("i should see the login page again")
	public void i_should_see_the_login_page_again() {
		 WebElement login = driver.findElement(By.className("login-box-msg"));
		  if(login.isDisplayed()) {
		  System.out.println(login.getText());
		  }
	}
	@And("i close the browser")
	public void i_close_the_browser() {
	    driver.close();
	}
	@Then("i should see error Message")
	public void i_should_see_error_message() {
	    WebElement alrt=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/h4"));
	    if(alrt.isDisplayed()) {
	    	System.out.println("Error Message: "+alrt.getText());
	    }
	}
	
	@When("I select flight date as {string}")
	public void i_select_flight_date_as(String string) {
		
	}
	
	@When("I select flight from {string}")
	public void i_select_flight_from(String string) {
	    
	}
	
	@When("I select flight to {string}")
	public void i_select_flight_to(String string) {
	    
	}
	
	@When("I click Search Flight")
	public void i_click_search_flight() {
	    
	}
	
	@Then("I Should see flight table")
	public void i_should_see_flight_table() {
	   
	}
	
	@When("I select airline name as {string}")
	public void i_select_airline_name_as(String string) {
	    
	}
	
	@Then("I take screen shot")
	public void i_take_screen_shot() {
	    
	}

}
