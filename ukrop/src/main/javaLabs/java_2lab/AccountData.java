package java_2lab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//класс, который описывает данные учетки и методы для нее

//поля класса, driver-для взаимодействия с веб-страницей
public class AccountData {
    private String username;
    private String password;
    private WebDriver driver;

//конструктор класса(для инициализации)
    public AccountData(WebDriver driver, String username, String password) {
        this.driver = driver;
        this.username = username;
        this.password = password;
    }
//метод возвращает логин
    public String getUsername() {
        return username;
    }
//метод возвращает пароль
    public String getPassword() {
        return password;
    }
//метод для входа на сайт
    public void login() {
        driver.findElement(By.id("Nik")).click();
        driver.findElement(By.id("Nik")).sendKeys(username);
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("login_subm")).click();
    }
}

