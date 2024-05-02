package java_5lab.Tests;
import java_5lab.Model.AccountData;
import java_5lab.Model.NoteData;
import java_5lab.Model.NoteEdit;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void fourthTest(){
        // Цикл по всем сгенерированным данным
        for (int i = 0; i < generateData().size(); i++){

            // Вывод информации о текущих сгенерированных данных
            System.out.println("№" + i + " " + generateData().get(i).getAddText() + " " + generateData().get(i).getKeyWord());

            // Действия по редактированию заметки с использованием сгенерированных данных
            app.noteHelper.create(generateData().get(i).getAddText());
            app.noteHelper.create(generateData().get(i).getKeyWord());
            app.noteHelper.create(generateData().get(i).getAddText());
            app.noteHelper.create(generateData().get(i).getKeyWord());
            app.noteHelper.create(generateData().get(i).getAddText());
            app.noteHelper.create(generateData().get(i).getKeyWord());

            // Выбор последней созданной заметки и открытие ее для проверки
            app.noteHelper.selectLastCreatedGroup();
            app.noteHelper.openSelectedGroup();
        }
    }

    // Метод для чтения данных из XML файла и создания списка объектов NoteData
    public static List<NoteData> generateData() {
        List<NoteData> noteDataList = new ArrayList<>();
        try
        {
            File fXmlFile = new File("/Users/karina/IdeaProjects/ukrop/src/main/javaLabs/java_5lab/ArrayOfGroupData.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("GroupData");

            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String genText = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String genKey = eElement.getElementsByTagName("keyword").item(0).getTextContent();
                    NoteData noteData = new NoteData(genText, genKey);
                    noteDataList.add(noteData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return noteDataList;
    }
}

