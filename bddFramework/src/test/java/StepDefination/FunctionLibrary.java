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

	@When("i select and enter date")
	public void i_select_and_enter_date(String string) {
		String year = driver.findElement(By.className("ui-datepicker-year")).getText();
		String month = driver.findElement(By.className("ui-datepicker-month")).getText();

		while (!year.equalsIgnoreCase("2026")) {
			driver.findElement(By.xpath("//span[contains(@class,'ui-icon-circle-triangle-e')]")).click();
			year = driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		while (!month.equalsIgnoreCase("February")) {
			driver.findElement(By.xpath("//span[contains(@class,'ui-icon-circle-triangle-e')]")).click();
			month = driver.findElement(By.className("ui-datepicker-month")).getText();
		}
		WebElement table = driver.findElement(By.className("ui-datepicker-calendar"));
		WebElement tableBody = table.findElement(By.tagName("tbody"));
		List<WebElement> trows = tableBody.findElements(By.tagName("tr"));
		for (int i = 0; i < trows.size(); i++) {
			List<WebElement> tcols = trows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < tcols.size(); j++) {
				String date = tcols.get(j).getText();
				if (date.equalsIgnoreCase("15")) {
					tcols.get(j).click();
					break;
				}
			}
		}
	}

	@Given("the user selects {string} as from city")
	public void the_user_selects_as_from_city(String string) {
		Select fFrom = new Select(driver.findElement(By.xpath("//select[contains(@class,'sf2')]")));
		fFrom.selectByVisibleText("Hyderabad");
	}

	@Given("the user selects {string} as to city")
	public void the_user_selects_as_to_city(String string) {
		Select fTo = new Select(driver.findElement(By.xpath("//select[contains(@class,'sf3')]")));
		fTo.selectByVisibleText("Kolkatha");
	}

	@When("i click search flight")
	public void i_click_search_flight() {
		driver.findElement(By.xpath("//button[contains(@class,'btn-search')]")).click();
	}

	@Then("list of available flights should be displayed")
	public void list_of_available_flights_should_be_displayed() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"flights-results\"]/div/div/div[2]"))); 
	}

	@When("i click on selected flight")
	public void i_click_on_selected_flight() {
		boolean airlineFound = false;
		try {
			WebElement flightSearch = driver.findElement(By.className("flights_table"));
			WebElement tb = flightSearch.findElement(By.tagName("tbody"));

			List<WebElement> trList = tb.findElements(By.tagName("tr"));

			for (WebElement row : trList) {
				List<WebElement> td = row.findElements(By.tagName("td"));

				if (td.size() > 1) {
					String airlineName = td.get(0).getText();
					if (airlineName.equalsIgnoreCase("Nagendra Airlines")) {
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
}
