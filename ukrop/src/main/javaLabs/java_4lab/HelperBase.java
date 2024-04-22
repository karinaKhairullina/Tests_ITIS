package java_4lab;

import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver driver;
    protected ApplicationManager app;

    public HelperBase(ApplicationManager app) {
        this.app = app;
        this.driver = app.getDriver();
    }
}
