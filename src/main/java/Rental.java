import java.util.Date;

public class Rental {
    private Book book;
    private Member member;
    private Date dateRented;
    private Date dateReturned;

    public Rental(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.dateRented = new Date();
    }

    public Rental(Book book, Member member, Date dateRented) {
        this.book = book;
        this.member = member;
        this.dateRented = dateRented;
    }

    // GETTERS
    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public Date getDateRented() {
        return dateRented;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    // SETTERS
    public void setBook(Book book) {
        this.book = book;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void rentNow() {
        this.dateRented = new Date();
    }

    public void setDateRented(Date dateRented) {
        this.dateRented = dateRented;
    }

    public void returnNow() {
        this.dateReturned = new Date();
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }
}
