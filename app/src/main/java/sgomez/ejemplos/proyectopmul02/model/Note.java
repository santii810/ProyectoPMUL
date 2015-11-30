package sgomez.ejemplos.proyectopmul02.model;

/**
 * Created by longui on 29/10/2015.
 */
public class Note {
    private String id;
    private String title;
    private String text;

    public Note() {
    }

    public Note(String text, String title) {
        this.text = text;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
