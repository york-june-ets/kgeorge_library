import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Create a library
        Library library = new Library("York Park Library", "123 Main St");
        System.out.println("Created library: " + library.getName());

        // Populate the library with data from file
        LibraryUtils.uploadAuthors(library, "/YorkParkLibrary_Authors.txt");
        System.out.println(library);
        LibraryUtils.uploadBooks(library, "/YorkParkLibrary_Books.txt");
        System.out.println(library);

        // Adding a new customer
        Member member = new Member("Max", "Feige", "123-456-7890", "mfeige@yorksolutions.com");
        library.addMember(member);
        System.out.println(library);

        // Member rents a book
        Rental rental = new Rental(library.searchBook("The Hunger Games", "Suzanne Collins"), member, 14);
        library.addRental(rental);
        System.out.println(library);
        rental.setDateReturned(LocalDate.now());
        System.out.println(library);
    }
}