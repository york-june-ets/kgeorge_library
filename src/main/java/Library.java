import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private String name;
    private String location;
    private final List<Book> books;
    private final List<Author> authors;
    private final List<Member> members;
    private final List<Rental> rentals;

    public Library(String name, String location) {
        this.name = name;
        this.location = location;
        this.books = new ArrayList<Book>();
        this.authors = new ArrayList<Author>();
        this.members = new ArrayList<Member>();
        this.rentals = new ArrayList<Rental>();
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // ADD
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book is required");
        }
        if (this.books.contains(book)) {
            throw new IllegalArgumentException("Book already exists");
        }
        this.books.add(book);
    }
    public void addAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author is required");
        }
        if (this.authors.contains(author)) {
            throw new IllegalArgumentException("Author already exists");
        }
        this.authors.add(author);
    }
    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member is required");
        }
        if (this.members.contains(member)) {
            throw new IllegalArgumentException("Member already exists");
        }
        this.members.add(member);
    }

    public void addRental(Rental rental) {
        if (rental == null) {
            throw new IllegalArgumentException("Rental is required");
        }
        if (this.rentals.contains(rental)) {
            throw new IllegalArgumentException("Rental already exists");
        }
        this.rentals.add(rental);
    }

    // SEARCH
    public Author getAuthorByName(String name) {
        return this.authors.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);
    }
    public Book searchBook(String title, String authorName) {
        return this.books.stream().filter(b -> b.getTitle().equals(title) && b.getAuthors().stream().anyMatch(a -> a.getName().equals(authorName))).findFirst().orElse(null);
    }
    public List<Book> searchBookByAuthor(Author author) {
        return this.books.stream().filter(b -> b.getAuthors().stream().anyMatch(a -> a.getID() == author.getID())).collect(Collectors.toList());

    }
}
