package project.steps;

import framework.driver.DriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static framework.utils.PropsReader.getPropertyNumber;

public class BaseSteps {
    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;
    private static final int EXPLICIT_TIMEOUT = getPropertyNumber("EXPLICIT_TIMEOUT");
    private static final int POLLING_TIMEOUT = getPropertyNumber("POLLING_TIMEOUT");

    public BaseSteps() {
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(EXPLICIT_TIMEOUT))
                .pollingEvery(Duration.ofMillis(POLLING_TIMEOUT))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
        try {
            webDriverWait.until(condition);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean waitForClose(By locator) {
        return waitForCondition(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitAndSwitchToPopup(WebElement el) {
        return waitForCondition(ExpectedConditions.frameToBeAvailableAndSwitchToIt(el));
    }

    public boolean waitForLocated(By loc) {
        return waitForCondition(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    public boolean elementOfClickable(WebElement el) {
        return waitForCondition(ExpectedConditions.elementToBeClickable(el));
    }

    public void clickOn(WebElement el) {
        elementOfClickable(el);
        el.click();
    }
}
