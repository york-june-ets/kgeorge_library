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
                if (props.length != 5) {
                    throw new Exception("Invalid data format");
                }
                String ISBN = props[0];
                String title = props[1];
                String[] authorNames = props[2].split(",");
                String year = props[3];
                String inStock = props[4];
                List<Author> authorList = new ArrayList<Author>();
                for (String authorName: authorNames) {
                    Author existingAuthor = library.getAuthorByName(authorName);
                    if (existingAuthor == null) {
                        throw new Exception("Author not found: " + authorName);
                    }
                }
                library.addBook(new Book(ISBN, title, authorList, Integer.parseInt(year), Integer.parseInt(inStock)));
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}