package java_3lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    private WebDriver driver;
    private String baseURL;
    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private NoteHelper noteHelper;

    public ApplicationManager(String baseURL, String username, String password) {
        this.baseURL = baseURL;
        driver = new FirefoxDriver();
        loginHelper = new LoginHelper(this, username, password);
        navigationHelper = new NavigationHelper(this, baseURL);
        noteHelper = new NoteHelper(this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public NoteHelper getNoteHelper() {
        return noteHelper;
    }

    public void stop() {
        driver.quit();
    }
}
