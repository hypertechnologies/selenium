package org.cucumber.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VehicleSearch {
    WebDriver driver;

    @Given("I navigate to google.com")
    public void navigate(){
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void iSearchFor(String searchTerm) {
        driver.findElement(By.name("q")).sendKeys(searchTerm);
        driver.findElement(By.name("btnK")).click();
    }

    @Then("I verify number of search result is visible")
    public void iVerifyNumberOfSearchResultIsVisible() {
        boolean isDisplayed = driver.findElement(By.cssSelector("#result-stats")).isDisplayed();

        Assert.assertTrue(isDisplayed);


    }
}
