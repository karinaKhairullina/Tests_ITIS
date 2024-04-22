package java_3lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase {
    private String username;
    private String password;

    public LoginHelper(ApplicationManager app, String username, String password) {
        super(app);
        this.username = username;
        this.password = password;
    }

    public void login() {
        driver.findElement(By.id("Nik")).click();
        driver.findElement(By.id("Nik")).sendKeys(username);
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("login_subm")).click();
    }
}
