package java_4lab;
import org.openqa.selenium.By;

public class NoteEditHelper extends HelperBase {

    public NoteEditHelper(ApplicationManager app) {
        super(app);
    }

    public void edit(String newText) {
        driver.findElement(By.linkText("Все записи")).click();
        driver.findElement(By.linkText("Править")).click();
        driver.findElement(By.id("DiText")).clear(); // Clear the existing text
        driver.findElement(By.id("DiText")).sendKeys(newText); // Set the new text
        driver.findElement(By.id("btn_save")).click();
    }

}
