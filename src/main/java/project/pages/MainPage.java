package project.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainPage extends BasePage {
    @FindBy(css = ".gqArsW")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//iframe/../..")
    private WebElement scriptTrigger;
    @FindBy(css = ".gqArsW")
    private WebElement errorMessage;
    @FindBy(tagName = "iframe")
    private WebElement modalWindow;
    @FindBy(css = "a[data-testid='popup-close-icon']")
    private WebElement closeButton;
}
