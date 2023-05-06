package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("User should be successfully logged in and logged out.");

        WebDriver driver;

        // Setup chrome browser
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        // Open a chrome browser
        driver = new ChromeDriver();

        // Navigate to the url https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        // Enter standard_user in the username field
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");

        // Enter password secret_sauce
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");

        // Click on login button
        driver.findElement(By.cssSelector("#login-button")).click();

        // Verify checkout icon is visible
        boolean checkoutIconDisplayed = driver.findElement(By.cssSelector("#shopping_cart_container > a")).isDisplayed();
        if(checkoutIconDisplayed){
            System.out.println("Icon is displayed");
        }else {
            System.out.println("Icon is NOT displayed");
        }

        // Logout
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#logout_sidebar_link")).click();

        // Wait 5 seconds
        Thread.sleep(5000);
        // Close the browser
        driver.quit();

    }

}
