import java.util.List;

public class Book {
    final String ISBN;
    final String title;
    final List<Author> authors;
    final int year;
    private int inStock;
    private boolean rented;

    public Book(String ISBN, String title, List<Author> authors, int year, int inStock) {
        this.ISBN = ISBN;
        this.title = title;
        this.authors = authors;
        this.year= year;
        this.inStock = inStock;
        this.rented = false;
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
    public boolean isRented() {
        return rented;
    }

    // SETTERS
    public void addToStock(int amount) {
        this.inStock += amount;
    }
    public void removeFromStock(int amount) {
        this.inStock -= amount;
    }
    public void setRented() {
        this.rented = true;
    }
    public void setReturned() {
        this.rented = false;
    }

    // PRINT
    @Override
    public String toString() {
        return this.ISBN + " : " + this.title + " (" + this.year + ")";
    }
}
