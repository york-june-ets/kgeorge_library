import java.time.LocalDate;

public class Rental {
    private static int counter = 0;
    private final int ID;
    private final Book book;
    private final Member member;
    private final LocalDate dateRented;
    private LocalDate dateDue;
    private LocalDate dateReturned;

    //  Constructor for new rentals
    public Rental(Book book, Member member, int rentalDurationDays) {
        if (book == null || member == null) {
            throw new IllegalArgumentException("Book and member are required");
        }
        if (rentalDurationDays <= 0) {
            throw new IllegalArgumentException("Rental duration must be greater than 0");
        }
        if (book.getInStock() < 1) {
            throw new IllegalArgumentException("Book is out of stock");
        }
        this.ID = counter;
        counter++;
        this.book = book;
        this.member = member;
        this.dateRented = LocalDate.now();
        this.dateDue = this.dateRented.plusDays(rentalDurationDays);
        this.dateReturned = null;
        this.book.removeFromStock(1);
    }
    // Constructor for existing rentals (may or may not be active)
    public Rental(Book book, Member member, LocalDate dateRented, int rentalDurationDays, LocalDate dateDue, LocalDate dateReturned) {
        if (book == null || member == null || dateRented == null || dateDue == null) {
            throw new IllegalArgumentException("Book and member are required");
        }
        if (rentalDurationDays <= 0) {
            throw new IllegalArgumentException("Rental duration must be greater than 0");
        }
        counter++;
        this.ID = counter;
        this.book = book;
        this.member = member;
        this.dateRented = dateRented;
        this.dateDue = this.dateRented.plusDays(rentalDurationDays);
        this.dateReturned = dateReturned;
    }

    // GETTERS
    public int getID() {
        return ID;
    }
    public Book getBook() {
        return book;
    }
    public Member getMember() {
        return member;
    }
    public LocalDate getDateRented() {
        return dateRented;
    }
    public LocalDate getDateDue() {
        return dateDue;
    }
    public LocalDate getDateReturned() {
        return dateReturned;
    }

    // SETTERS
    public void setDateDue(LocalDate dateDue) {
        this.dateDue = dateDue;
    }
    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
        this.book.addToStock(1);
    }

    // PRINT
    @Override
    public String toString() {
        return "Rental: " + this.book.getTitle() + " (" + this.dateRented + " - " + this.dateDue + ")";
    }
}
