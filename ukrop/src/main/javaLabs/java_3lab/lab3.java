package java_3lab;

import org.junit.Test;

public class lab3 extends TestBase {

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
