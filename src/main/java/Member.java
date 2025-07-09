import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private List<Book> activeRentals;

    public Member(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activeRentals = new ArrayList<Book>();
    }

    public void addActiveRental(Book book) {
        this.activeRentals.add(book);
    }

    public void removeActiveRental(Book book) {
        this.activeRentals.remove(book);
    }
}
