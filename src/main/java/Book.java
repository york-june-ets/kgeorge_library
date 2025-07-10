import java.util.List;

public class Book {
    final String ISBN;
    final String title;
    final List<Author> authors;
    final int year;
    private int inStock;

    public Book(String ISBN, String title, List<Author> authors, int year, int inStock) {
        if (ISBN == null || title == null || authors == null || year <= 0 || inStock <= 0) {
            throw new IllegalArgumentException("ISBN, title, authors, year, and inStock are required");
        }
        this.ISBN = ISBN;
        this.title = title;
        this.authors = authors;
        this.year= year;
        this.inStock = inStock;
    }

    // GETTERS
    public String getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    public List<Author> getAuthors() {
        return authors;
    }
    public int getYear() {
        return year;
    }
    public int getInStock() {
        return inStock;
    }

    // SETTERS
    public void addToStock(int amount) {
        this.inStock += amount;
    }
    public void removeFromStock(int amount) {
        this.inStock -= amount;
    }

    // PRINT
    @Override
    public String toString() {
        return this.ISBN + " : " + this.title + " (" + this.year + ")";
    }
}
