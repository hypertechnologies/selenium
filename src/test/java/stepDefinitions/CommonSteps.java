package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class CommonSteps extends Base {
    @Given("I navigate to {string}")
    public void navigate(String url){
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        ChromeOptions option=new ChromeOptions();
        option.setPageLoadStrategy(PageLoadStrategy.NONE);

        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(implicitWaitTime));

        driver.get(url);
    }

    @And("I quit the browser")
    public void iQuitTheBrowser() {
        driver.quit();
    }
}
