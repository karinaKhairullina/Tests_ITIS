package java_1lab;// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class TestAuthRegTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test  public void testAuthReg() throws InterruptedException {
    driver.get("https://diary.anek.ws/");
    driver.manage().window().setSize(new Dimension(1453, 865));
    driver.findElement(By.id("Nik")).click();
    driver.findElement(By.id("Nik")).sendKeys("Karina");
    driver.findElement(By.id("Password")).click();
    driver.findElement(By.id("Password")).sendKeys("nchi4792");
    driver.findElement(By.id("login_subm")).click();
  }
}
