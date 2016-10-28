package quyntg.vn.session11.Models;

/**
 * Created by giaqu on 10/26/2016.
 */
public class Quote {
    private int id;
    private String title;
    private String content;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quote(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Quote(String title, String content) {
        this(-1, title, content);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", id, title, content);
    }
}
