package java_3lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NoteHelper extends HelperBase {

    public NoteHelper(ApplicationManager app) {
        super(app);
    }

    public String getLastCreatedNoteText() {
        return driver.findElement(By.id("DiText")).getText();
    }


    public void create(String noteText) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openHomePage();

        driver.findElement(By.id("DiText")).click();
        driver.findElement(By.id("DiText")).sendKeys(noteText);
        driver.findElement(By.id("btn_save")).click();
    }
}
