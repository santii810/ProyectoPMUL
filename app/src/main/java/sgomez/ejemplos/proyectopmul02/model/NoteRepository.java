package sgomez.ejemplos.proyectopmul02.model;

import java.util.ArrayList;

/**
 * Created by longui on 29/10/2015.
 */
public interface NoteRepository {
    public ArrayList<Note> getNotes();

    public void addNote(Note note);

    public void deleteNote(String noteId);

    public Note getNote(String noteId);
}
