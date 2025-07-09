import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private List<Book> books;

    public Author(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        if (!this.books.contains(book)) {
            this.books.add(book);
        }
    }
}
