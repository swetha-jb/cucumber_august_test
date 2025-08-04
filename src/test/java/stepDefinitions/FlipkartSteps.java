package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.FlipkartLoginPage;

import java.time.Duration;

public class FlipkartSteps {

    WebDriver driver;
    FlipkartLoginPage loginPage;

    @Given("user is on Flipkart homepage")
    public void user_is_on_flipkart_homepage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
        loginPage = new FlipkartLoginPage(driver);
    }

    @When("user closes the login popup")
    public void user_closes_popup() {
        loginPage.closeLoginPopup();
        loginPage.clickLoginButton();
    }

    @Then("login button should be visible and clickable")
    public void login_button_visible() {
        assert loginPage.isLoginButtonDisplayed();
        driver.quit();
    }
}
