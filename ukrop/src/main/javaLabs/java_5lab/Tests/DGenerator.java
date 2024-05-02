package java_5lab.Tests;

import java.util.ArrayList;
import java.util.List;

import java_5lab.Model.NoteData;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class DGenerator extends TestBase{
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

            // Получение текста последней созданной заметки
            String lastCreatedNoteText = app.noteHelper.getLastCreatedNoteText();

            // Проверка, что текст последней созданной заметки соответствует ожидаемому тексту из сгенерированных данных
            Assert.assertEquals(generateData().get(i).getAddText(), lastCreatedNoteText);
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
