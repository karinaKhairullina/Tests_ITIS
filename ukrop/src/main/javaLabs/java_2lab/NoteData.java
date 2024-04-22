package java_2lab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NoteData {
    private WebDriver driver;

    public NoteData(WebDriver driver) {
        this.driver = driver;
    }

    public void create(String noteText) {
        driver.findElement(By.id("DiText")).click();
        driver.findElement(By.id("DiText")).sendKeys(noteText);
        driver.findElement(By.id("btn_save")).click();
    }
}

