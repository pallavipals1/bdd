package StepDefination;

import java.io.File;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	@When("i close the browser")
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
	public void i_select_flight_date_as(String flightDate) {
		driver.findElement(By.id("search-date")).sendKeys(flightDate);
	}
	
	@When("I select flight from {string}")
	public void i_select_flight_from(String flightFrom) {
	    Select flightF = new Select(driver.findElement(By.xpath("//select[contains(@class,'sf2')]")));
	    flightF.selectByVisibleText(flightFrom);
	}
	
	@When("I select flight to {string}")
	public void i_select_flight_to(String flightTo) {
	    Select flightT = new Select(driver.findElement(By.xpath("//select[contains(@class,'sf3')]")));
	    flightT.selectByVisibleText(flightTo);
	}
	
	@When("I click Search Flight")
	public void i_click_search_flight() {
	    driver.findElement(By.xpath("//button[contains(@class,'btn-search')]")).click();
	}
	
	@Then("I Should see flight table")
	public void i_should_see_flight_table() {
	  WebElement flightTable = driver.findElement(By.xpath("//div[@class='modal-content']"));
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOf(flightTable));
	    if(flightTable.isDisplayed()) {
	    	System.out.println("flight table");
	    }
	}
	
	@When("I select airline name as {string}")
	public void i_select_airline_name_as(String airline) {
		boolean airlineFound = false;
		try {
			 WebElement flightTable = driver.findElement(By.xpath("//div[@class='modal-content']"));
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			    wait.until(ExpectedConditions.visibilityOf(flightTable));
			WebElement flightSearch = driver.findElement(By.className("flights_table"));
			WebElement tb = flightSearch.findElement(By.tagName("tbody"));

			List<WebElement> trList = tb.findElements(By.tagName("tr"));

			for (WebElement row : trList) {
				List<WebElement> td = row.findElements(By.tagName("td"));

				if (td.size() > 1) {
					String airlineName = td.get(0).getText();
					if (airlineName.equalsIgnoreCase(airline)) {
						System.out.println("Selecting airline: " + airlineName);
						WebElement selectButton = td.get(td.size() - 1)
								.findElement(By.xpath(".//*[contains(text(), 'Select')]"));
						selectButton.click();

						System.out.println("Clicked 'Select' button for: " + airlineName);
						airlineFound = true;
						break; // Stop loop after clicking the button for "Soft Airlines"
					}
				}
			}
		} catch (Exception e) {
			if (!airlineFound) {
//				System.out.println("Soft Airlines not found in the table.");
			}
		}
	}
	
	@Then("I take screen shot")
	public void i_take_screen_shot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("screenshot/flightBooking.png");
		FileUtils.copyFile(src, trg);
	}
	
	@When("i enter the name as {string}")
	public void i_enter_the_name_as(String Name) {
		driver.findElement(By.id("name")).sendKeys(Name);
	}
	
	@When("i select class")
	public void i_select_class() {
		driver.findElement(By.cssSelector("input[type='radio'][value='Business']")).click();
	}

	@When("i click insert order")
	public void i_click_insert_order() {
		driver.findElement(By.xpath("//button[contains(@class,'insert-order active')]")).click();
		
	}



}
