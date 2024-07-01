import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.enums.Url;
import project.steps.MainPageSteps;

public class ButtonsPopupTest extends BaseTest {
    MainPageSteps mainPageSteps = new MainPageSteps();
    private final Logger log = LogManager.getLogger("AutomationFramework");

    @BeforeEach
    public void beforeClass() {
        open(Url.HOMEPAGE.getUrl());
    }

    @Test
    public void VerifyButtonTest() {
        log.info("Wait popup and change attribute to fast load");
        mainPageSteps.waitToWindow();
        log.info("Check button to clickable and result");
        mainPageSteps.checkButton();
        log.info("Close popup and check for close");
        mainPageSteps.closePopup();
    }
}
