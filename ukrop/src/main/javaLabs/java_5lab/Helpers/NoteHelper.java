package java_5lab.Helpers;
import java_5lab.ApplicationManager;
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

    public void selectLastCreatedGroup() {
        driver.findElement(By.linkText("Все записи")).click();
    }

    public void openSelectedGroup() {
        driver.findElement(By.linkText("Править")).click();
    }
}

