package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feautureFiles/BookFlight.feature",glue = "StepDefination",dryRun = false,tags = "@BookFlightTest1")

public class BookFlightTestCase {
}
