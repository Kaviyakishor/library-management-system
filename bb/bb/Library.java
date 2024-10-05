import java.io.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private final String fileName = "library_data.txt";  // File to store book data

    public Library() {
        books = new ArrayList<>();
        loadBooksFromFile();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
        System.out.println("Book '" + book.getTitle() + "' added to the library.");
    }

    // Display available books
    public void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (!book.isIssued()) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }

    // Find a book by its title
    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Save books to a file for persistence
    private void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Book book : books) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.isIssued());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books to file: " + e.getMessage());
        }
    }

    // Load books from a file when the program starts
    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                if (bookData.length == 3) {
                    String title = bookData[0];
                    String author = bookData[1];
                    boolean isIssued = Boolean.parseBoolean(bookData[2]);
                    Book book = new Book(title, author);
                    if (isIssued) {
                        book.issueBookWithoutMessage();
                    }
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading books from file: " + e.getMessage());
        }
    }
}
