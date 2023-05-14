package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class DemoQA_Checkbox extends Base{
    @When("I select public and private")
    public void iSelectPublicAndPrivate() {
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > button")).click();
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > button")).click();
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(2) > span > button")).click();

        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(1) > span > label")).click();
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(2) > span > label")).click();
    }

    @Then("I should see {string}")
    public void iShouldSee(String text) {
        String result = driver.findElement(By.cssSelector("#result")).getText();
        assert result.contains(text);
    }
}
