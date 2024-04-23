package java_3lab;

import org.openqa.selenium.By;

public class NoteEditHelper extends HelperBase {

    public NoteEditHelper(ApplicationManager app) {
        super(app);
    }

    public void edit(String newText) {
        driver.findElement(By.linkText("Все записи")).click();
        driver.findElement(By.linkText("Править")).click();
        driver.findElement(By.id("DiText")).clear();
        driver.findElement(By.id("DiText")).sendKeys(newText);
        driver.findElement(By.id("btn_save")).click();
    }
}
