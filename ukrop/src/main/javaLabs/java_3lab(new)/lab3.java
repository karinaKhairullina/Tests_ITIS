package java_3lab;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class lab3 extends TestBase {

    @Test
    public void a_testLogin() {
        app.getNavigationHelper().openHomePage();
        AccountData user = new AccountData(app.getLoginHelper());
        user.login();
    }

    @Test
    public void b_testAddNote() {
        app.getNavigationHelper().openHomePage();
        AccountData user = new AccountData(app.getLoginHelper());
        NoteData note = new NoteData(app.getNoteHelper());
        note.create("Это новая заметка!");

        // Получаем текст последней созданной заметки
        String lastCreatedNoteText = app.getNoteHelper().getLastCreatedNoteText();

        // Проверяем, что текст заметки соответствует ожидаемому
        Assert.assertEquals("Это новая заметка!", lastCreatedNoteText);

    }

    @Test
    public void c_testEditNote() {
        app.getNavigationHelper().openHomePage();
        AccountData user = new AccountData(app.getLoginHelper());
        NoteEdit note = new NoteEdit(app.getNoteEditHelper());
        note.edit("Теперь это исправленная заметка!");
    }
}

