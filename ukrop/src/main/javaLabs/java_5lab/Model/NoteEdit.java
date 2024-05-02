package java_5lab.Model;
import java_5lab.Helpers.NoteEditHelper;

public class NoteEdit {
    private NoteEditHelper noteEditHelper;

    public NoteEdit(NoteEditHelper noteEditHelper) {

        this.noteEditHelper = noteEditHelper;
    }

    public void edit(String noteText) {

        noteEditHelper.edit(noteText);
    }
}
