package java_4lab;

public class NoteEdit {
    private NoteEditHelper noteEditHelper;

    public NoteEdit(ApplicationManager app) {

        this.noteEditHelper = noteEditHelper;
    }

    public void editNote(String newText) {
        noteEditHelper.edit(newText);
    }
}
