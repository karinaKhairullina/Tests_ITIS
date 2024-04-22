package java_4lab;

import org.openqa.selenium.By;


public class NoteHelper extends HelperBase {

    public NoteHelper(ApplicationManager app) {
        super(app);
    }

    public void create(String noteText) {
        driver.findElement(By.id("DiText")).click();
        driver.findElement(By.id("DiText")).sendKeys(noteText);
        driver.findElement(By.id("btn_save")).click();
    }
}