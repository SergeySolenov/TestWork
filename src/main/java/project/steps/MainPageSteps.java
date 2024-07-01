package project.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import project.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageSteps extends BaseSteps {
    private final MainPage popupPage = new MainPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public MainPageSteps waitToWindow() {
        waitForLocated(By.tagName("iframe"));
        js.executeScript("arguments[0].style.visibility = 'visible'", popupPage.getScriptTrigger());
        js.executeScript("arguments[0].style.height = '712px'", popupPage.getModalWindow());
        waitAndSwitchToPopup(popupPage.getModalWindow());
        return this;
    }

    public MainPageSteps checkButton() {
        clickOn(popupPage.getButtonSubmit());
        assertTrue(popupPage.getErrorMessage().isDisplayed(), "Error message is visible");
        return this;
    }

    public MainPageSteps closePopup() {
        elementOfClickable(popupPage.getCloseButton());
        clickOn(popupPage.getCloseButton());
        waitForClose(By.tagName("iframe"));
        return this;
    }
}
