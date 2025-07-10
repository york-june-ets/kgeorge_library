import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LibraryUtils {
    static public void uploadAuthors(Library library, String authorDataFile) {
        try (InputStream authorData = Main.class.getResourceAsStream(authorDataFile)) {
            if (authorData == null) {
                throw new Exception("Cannot find file: " + authorDataFile);
            }
            Scanner scanner = new Scanner(authorData);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] props = line.split("\\|", -1);
                if (props.length != 6) {
                    throw new Exception("Invalid data format");
                }
                int ID = Integer.parseInt(props[0]);
                String name = props[1].trim();
                String bio = props[2];
                String gender = props[3].isEmpty() ? "" : props[3].trim();
                LocalDate birthDate = LocalDate.parse(props[4]);
                LocalDate deathDate = props[5].isEmpty() ? null : LocalDate.parse(props[5]);
                library.addAuthor(new Author(ID, name, bio, gender, birthDate, deathDate));
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }


    static public void uploadBooks(Library library, String bookDataFile) {
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
                String ISBN = props[0].trim();
                String title = props[1].trim();
                String[] authorNames = props[2].split(",");
                String year = props[3];
                String inStock = props[4];
                List<Author> authorList = new ArrayList<Author>();
                for (String authorName: authorNames) {
                    authorName = authorName.trim();
                    Author existingAuthor = library.getAuthorByName(authorName);
                    if (existingAuthor == null) {
                        throw new Exception("Author not found: " + authorName);
                    }
                    authorList.add(existingAuthor);
                }
                library.addBook(new Book(ISBN, title, authorList, Integer.parseInt(year), Integer.parseInt(inStock)));
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

}