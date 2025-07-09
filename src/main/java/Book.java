import java.util.Date;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private int year;
    private boolean rented;

    public Book(String title, List<Author> author, int year) {
        this.title = title;
        this.authors = author;
        this.year= year;
        this.rented = false;
    }

    // GETTERS
    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    public boolean isRented() {
        return rented;
    }

    // SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRented() {
        this.rented = true;
    }

    public void setReturned() {
        this.rented = false;
    }
}
