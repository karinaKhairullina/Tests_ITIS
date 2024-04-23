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

        // Получаем логин созданного юзера
        String lastUserCreated = app.getLoginHelper().assertUsername();

        // Проверяем, что логин юзера соответствует ожидаемому
        Assert.assertEquals("Karina", lastUserCreated);

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

        // Получаем текст последней отредактированной заметки
        String lastEditNote = app.getNoteEditHelper().getLastEditNote();

        // Проверяем, что отредактированная заметка соответствует ожидаемому
        Assert.assertEquals("Теперь это исправленная заметка!", lastEditNote);


    }
}

