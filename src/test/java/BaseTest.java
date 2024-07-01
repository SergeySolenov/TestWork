import framework.driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    public void open(String url) {
        DriverSingleton.getDriver().get(url);
    }
    @AfterEach()
    public void afterClass() {
        DriverSingleton.closeDriver();
    }
}
