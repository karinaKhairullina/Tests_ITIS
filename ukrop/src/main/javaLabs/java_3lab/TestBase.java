package java_3lab;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = new ApplicationManager("https://diary.anek.ws/", "username", "password");
    }

    @After
    public void tearDown() {
        app.stop();
    }
}
