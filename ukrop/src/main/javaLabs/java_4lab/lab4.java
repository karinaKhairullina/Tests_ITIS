package java_4lab;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class lab4 extends TestBase {

    @BeforeClass
    public static void setUpClass() {
        app = ApplicationManager.getInstance("https://diary.anek.ws/", "Karina", "nchi4792");
    }

    @AfterClass
    public static void tearDownClass() {
        app.close();
    }

    @Test
    public void testLogin() {
        app.getNavigationHelper().openHomePage();
        LoginHelper loginHelper = new LoginHelper(app, "Karina", "nchi4792");
        AccountData user = new AccountData(loginHelper);
        user.login();
    }

    @Test
    public void testAddNote() {
        app.getNavigationHelper().openHomePage();
        LoginHelper loginHelper = new LoginHelper(app, "Karina", "nchi4792");
        AccountData user = new AccountData(loginHelper);
        user.login();
        String noteText = "Test Karina new lab2";
        NoteHelper noteHelper = new NoteHelper(app);
        NoteData note = new NoteData(noteHelper);
        note.create(noteText);
    }



}
