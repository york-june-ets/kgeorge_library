import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private int year;
    private int inStock;
    private boolean rented;

    public Book(String title, List<Author> authors, int year, int inStock) {
        this.title = title;
        this.authors = authors;
        this.year= year;
        this.inStock = inStock;
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

    public int getInStock() {
        return inStock;
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

    // Print
    public void printData() {
        System.out.println("Title: " + this.title);
        System.out.println("Authors: " + this.authors);
        System.out.println("Year: " + this.year);
        System.out.println("Rented: " + this.rented);
    }
}
