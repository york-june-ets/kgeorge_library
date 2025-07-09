import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LibraryUtils {
    static public void populateLibrary(Library library, String bookDataFile) {
        try (InputStream bookData = Main.class.getResourceAsStream(bookDataFile)) {
            if (bookData == null) {
                throw new Exception("Cannot find file: " + bookDataFile);
            }
            Scanner scanner = new Scanner(bookData);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] props = line.split("\\|");
                if (props.length != 4) {
                    throw new Exception("Invalid data format");
                }
                String title = props[0];
                String[] authors = props[1].split(",");
                String year = props[2];
                String inStock = props[3];
                List<Author> authorList = new ArrayList<Author>();
                for (String author: authors) {
                    Author newOrExistingAuthor = library.addAuthorByName(author);
                    authorList.add(newOrExistingAuthor);
                }
                library.addBook(new Book(title, authorList, Integer.parseInt(year), Integer.parseInt(inStock)));
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void createRental(Library library, Member member, List<Book> books, Date dateRented) {
        for (Book book: books) {
            if (book.getInStock() > 0) {
                if (dateRented == null) {
                    library.addRental(new Rental(book, member));
                } else {
                    library.addRental(new Rental(book, member, dateRented));
                }
                member.addActiveRental(book);
                book.setRented();
                book.removeFromStock(1);
            }
        }
    }

    public static void closeOutRental(Library library, Member member, List<Book> books, Date dateReturned) {
        for (Book book: books) {
                Rental activeRental = library.getRentals().stream().filter(rental -> rental.getMember() == member && rental.getBook() == book).findAny().orElse(null);
            if (book.isRented() && activeRental != null) {
                if (dateReturned == null) {
                    activeRental.returnNow();
                } else {
                    activeRental.setDateReturned(dateReturned);
                }
                member.removeActiveRental(book);
                book.setReturned();
                book.addToStock(1);
            } else {
                System.out.println("There is no record of " + book.getTitle() + "being rented.");
            }
        }
    }

}