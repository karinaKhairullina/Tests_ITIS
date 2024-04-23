package java_3lab;


public class NoteEdit {
    private NoteEditHelper noteEditHelper;

    public NoteEdit(NoteEditHelper noteEditHelper) {

        this.noteEditHelper = noteEditHelper;
    }

    public void edit(String noteText) {

        noteEditHelper.edit(noteText);
    }
}
