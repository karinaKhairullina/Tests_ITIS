package java_4lab.Helpers;

import java_4lab.ApplicationManager;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {
    private String username;
    private String password;

    public LoginHelper(ApplicationManager app, String username, String password) {
        super(app);
        this.username = username;
        this.password = password;
    }

    public String assertUsername() {
        return app.getDriver().findElement(By.id("author")).getText();
    }

    public void login() {
        driver.findElement(By.id("Nik")).click();
        driver.findElement(By.id("Nik")).sendKeys(username);
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("login_subm")).click();
    }
}
