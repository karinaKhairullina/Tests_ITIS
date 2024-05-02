package java_5lab.Helpers;
import java_5lab.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NoteEditHelper extends HelperBase {

    public NoteEditHelper(ApplicationManager app) {
        super(app);
    }

    public String getLastEditNote() {
        WebElement noteElement = app.getDriver().findElement(By.xpath("(//div[contains(@class, 'dt')])[last()]"));
        return noteElement.getText();
    }

    public void edit(String newText) {
        driver.findElement(By.linkText("Все записи")).click();
        driver.findElement(By.linkText("Править")).click();
        driver.findElement(By.id("DiText")).clear();
        driver.findElement(By.id("DiText")).sendKeys(newText);
        driver.findElement(By.id("btn_save")).click();
    }
}
