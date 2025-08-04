package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlipkartLoginPage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement loginButton;

    public FlipkartLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // ✅ Required for @FindBy
    }

    public void closeLoginPopup() {
        try {
            WebElement closeBtn = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            closeBtn.click();
        } catch (Exception e) {
            System.out.println("Login popup not present.");
        }
    }

    public void clickLoginButton() {
        loginButton.click(); // ✅ Use the initialized WebElement
    }

    public boolean isLoginButtonDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(loginButton));
            return loginButton.isDisplayed();
        } catch (Exception e) {
            System.out.println("Login button not found or not visible: " + e.getMessage());
            return false;
        }
    }
}
