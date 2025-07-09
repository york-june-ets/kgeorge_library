import java.io.InputStream;
import java.util.ArrayList;
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
                if (props.length != 3) {
                    throw new Exception("Invalid data format");
                }
                String title = props[0];
                String[] authors = props[1].split(",");
                String year = props[2];
                List<Author> authorList = new ArrayList<Author>();
                for (String author: authors) {
                    Author newOrExistingAuthor = library.addAuthorByName(author);
                    authorList.add(newOrExistingAuthor);
                }
                library.addBook(new Book(title, authorList, Integer.parseInt(year)));
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

}