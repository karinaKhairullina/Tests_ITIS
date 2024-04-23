package java_3lab;

public class NoteData {
    private NoteHelper noteHelper;

    public NoteData(NoteHelper noteHelper) {
        this.noteHelper = noteHelper;
    }

    public void create(String noteText) {
        noteHelper.create(noteText);
    }

    public String getLastCreatedNoteText() {
        return noteHelper.getLastCreatedNoteText();
    }
}