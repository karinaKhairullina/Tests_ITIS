package java_4lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    private static final ThreadLocal<ApplicationManager> appManagerInstance = new ThreadLocal<>();

    private WebDriver driver;
    private String baseURL;
    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private NoteHelper noteHelper;
    private NoteEditHelper noteEditHelper;

    private ApplicationManager(String baseURL, String username, String password) {
        this.baseURL = baseURL;
        driver = new FirefoxDriver();
        loginHelper = new LoginHelper(this, username, password);
        navigationHelper = new NavigationHelper(this, baseURL);
        noteHelper = new NoteHelper(this);
        noteEditHelper = new NoteEditHelper(this);
    }

    public static ApplicationManager getInstance(String baseURL, String username, String password) {
        if (appManagerInstance.get() == null) {
            ApplicationManager appManager = new ApplicationManager(baseURL, username, password);
            appManagerInstance.set(appManager);
        }
        return appManagerInstance.get();
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

    public NoteEditHelper getNoteEditHelper() {
        return noteEditHelper;
    }

    public void close() {
        driver.quit();
        appManagerInstance.remove();
    }
}
