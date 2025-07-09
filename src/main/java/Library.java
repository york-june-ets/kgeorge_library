import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String location;
    private List<Book> books;
    private List<Author> authors;
    private List<Member> members;
    private List<Rental> rentals;

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
        if (!this.books.contains(book)) {
            this.books.add(book);
        }
        for (Author author: book.getAuthors()) {
            if (!author.getBooks().contains(book)) {
                author.addBook(book);
            }
        }
    }

    public void addAuthorByName(String authorName) {
        if (this.authors.stream().noneMatch(author -> author.getName().equals(authorName))) {
            Author newAuthor = new Author(authorName);
            this.authors.add(newAuthor);
        }
    }

    public void addMember(Member member) {
        if (!this.members.contains(member)) {
            this.members.add(member);
        }
    }

    public void addRental(Rental rental) {
        if (!this.rentals.contains(rental)) {
            this.rentals.add(rental);
        }
    }

    public void printData() {
        System.out.println("Name: " + this.name);
        System.out.println("Location: " + this.location);
        System.out.println("Books: " + this.books);
        System.out.println("Authors: " + this.authors);
        System.out.println("Members: " + this.members);
        System.out.println("Rentals: " + this.rentals);
    }


}
