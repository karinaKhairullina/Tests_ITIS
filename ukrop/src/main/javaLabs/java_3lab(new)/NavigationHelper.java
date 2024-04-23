package java_3lab;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    private String baseURL;

    public NavigationHelper(ApplicationManager app, String baseURL) {
        super(app);
        this.baseURL = baseURL;
    }

    public void openHomePage() {
        driver.get(baseURL);
    }
}
