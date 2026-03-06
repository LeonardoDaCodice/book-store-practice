import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of books in the library.
 */
public class Library {

    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    /**
     * Adds a book to the library.
     */
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    /**
     * Removes a book from the library using its ISBN.
     */
    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    /**
     * Returns a list of all books in the library.
     */
    public List<Book> listBooks() {
        return new ArrayList<>(books.values());
    }

    /**
     * Returns all books written by the specified author.
     */
    public List<Book> getBooksByAuthor(String author) {

        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }

        return result;
    }
}