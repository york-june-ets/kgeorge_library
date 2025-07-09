public class Main {
    public static void main(String[] args) {
        //Create a library
        Library library = new Library("York Park Library", "123 Main St");
        System.out.println("Created library: " + library.getName());

        // Populate the library with data from file
        LibraryUtils.populateLibrary(library, "/YorkParkLibrary_Books.txt");
        System.out.println(library);



    }
}