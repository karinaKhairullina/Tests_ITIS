package java_3lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NoteHelper extends HelperBase {

    public NoteHelper(ApplicationManager app) {
        super(app);
    }

    public String getLastCreatedNoteText() {
        WebElement noteElement = app.getDriver().findElement(By.cssSelector("div.dt"));
        return noteElement.getText();
    }

    public void create(String noteText) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openHomePage();

        app.getDriver().findElement(By.id("DiText")).click();
        app.getDriver().findElement(By.id("DiText")).sendKeys(noteText);
        app.getDriver().findElement(By.id("btn_save")).click();
    }
}

