package java_5lab;
import java_5lab.Helpers.LoginHelper;
import java_5lab.Helpers.NavigationHelper;
import java_5lab.Helpers.NoteEditHelper;
import java_5lab.Helpers.NoteHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    private static ApplicationManager instance;
    private static long threadId; // Добавляем переменную для отслеживания идентификатора потока
    private WebDriver driver;
    private String baseURL;
    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    public NoteHelper noteHelper;
    private NoteEditHelper noteEditHelper;

    // Приватный конструктор, чтобы запретить внешний вызов
    private ApplicationManager(String baseURL, String username, String password) {
        this.baseURL = baseURL;
        driver = new FirefoxDriver();
        loginHelper = new LoginHelper(this, username, password);
        navigationHelper = new NavigationHelper(this, baseURL);
        noteHelper = new NoteHelper(this);
        noteEditHelper = new NoteEditHelper(this);

        // Записываем идентификатор потока при создании экземпляра ApplicationManager
        threadId = Thread.currentThread().getId();
    }

    // Получение экземпляра менеджера
    public static synchronized ApplicationManager getInstance(String baseURL, String username, String password) {
        // Проверяем, если экземпляр уже существует и идентификатор текущего потока совпадает с предыдущим
        if (instance == null || threadId != Thread.currentThread().getId()) {
            instance = new ApplicationManager(baseURL, username, password);
        }
        return instance;
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

    // Метод для явного освобождения ресурсов
    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
