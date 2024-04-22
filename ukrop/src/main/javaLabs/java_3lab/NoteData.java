package java_3lab;

import org.openqa.selenium.WebDriver;

public class NoteData {
    private NoteHelper noteHelper;

    public NoteData(NoteHelper noteHelper) {
        this.noteHelper = noteHelper;
    }

    public void create(String noteText) {
        noteHelper.create(noteText);
    }
}