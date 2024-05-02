package java_5lab.Model;
import java_5lab.Helpers.NoteHelper;

public class NoteData {
    private String addText;
    private String keyWord;
    private NoteHelper noteHelper;

    public NoteData(String addText, String keyWord) {
        this.addText = addText;
        this.keyWord = keyWord;
    }

    public NoteData(NoteHelper noteHelper) {
        this.noteHelper = noteHelper;
    }

    public void create(String noteText) {
        noteHelper.create(noteText);
    }

    public String getLastCreatedNoteText() {
        return noteHelper.getLastCreatedNoteText();
    }

    public String getAddText() {
        return addText;
    }

    public void setAddText(String addText) {
        this.addText = addText;
    }

    //необязательный
    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

}