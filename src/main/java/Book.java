import java.util.Date;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private Date datePublished;
    private String rented;

    public Book(String title, List<Author> author, Date datePublished) {
        this.title = title;
        this.authors = author;
        this.datePublished = datePublished;
    }

    // GETTERS
    public List<Author> getAuthors() {
        return authors;
    }
}
