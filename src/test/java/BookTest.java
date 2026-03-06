
/**
 * This is a test class for the Book class.
 * 
 * To run all the tests in this class, run the following command from the project root:
 * `mvn test -Dtest=BookTest`
 * 
 * To run a single test method, run the following command from the project root:
 * `mvn test -Dtest=BookTest#testMethodName`
 * For example, to run the assertBookExists test, use the following command:
 * `mvn test -Dtest=BookTest#assertBookExists`
 * 
 * --------------------------------------------------------------------------------------
 * 
 * HOW TESTS ARE WRITTEN.
 * 
 * A test class is a class that contains methods that test the functionality of another class.
 * In this case, this class tests the functionality of the Library class.
 * 
 * Each method that tests a specific functionality is annotated with the `@Test` annotation.
 * This annotation tells the test runner that this method is a test case.
 * 
 * Inside each test method, you should:
 * 1. Set up the conditions for the test. This is called the "arrange" phase.
 * 2. Call the method that you want to test. This is called the "act" phase.
 * 3. Verify that the result is what you expect. This is called the "assert" phase.
 * 
 * For example, in the `assertBookExists` test, we want to verify that when a book is added to the library,
 * it can be retrieved.
 * 
 * 1. Arrange: we create a new Library and a new Book.
 * 2. Act: we add the book to the library.
 * 3. Assert: we retrieve the book from the library and verify that it is the same book that we added.
 * 
 * To verify the result, we use assertions. Assertions are methods that check for a specific condition and
 * throw an error if the condition is not met.
 * 
 * For example, `assertEquals(expected, actual)` verifies that the expected value is equal to the actual value.
 * `assertNotNull(object)` verifies that the object is not null.
 * 
 * You can find more assertions in the JUnit documentation: https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void assertBookCreation() {
        // Arrange: we create a new Book object.
        final String title = "The Lord of the Rings";
        final String author =  "J.R.R. Tolkien";
        final String isbn = "f276d2bb-d9aa-43c0-9fe9-e1ec89a33c39";

        Book book = new Book(title, author, isbn);

        // Act: we don't need to do anything for this test.

        // Assert: we verify that the book object has the correct properties.
        assertNotNull(book);
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(isbn, book.getIsbn());
    }

    @Test
    void testAddBook() {

        Library library = new Library();

        Book book = new Book("1984", "George Orwell", "1");

        library.addBook(book);
        List<Book> books = library.listBooks();

        assertEquals(1, books.size());
        assertEquals("1984", books.get(0).getTitle());
    }

    @Test
    void testRemoveBook() {
  
        Library library = new Library();

        Book book = new Book("1984", "George Orwell", "1");

        library.addBook(book);
        library.removeBook("1");

        assertEquals(0, library.listBooks().size());
    }

    @Test
    void testListBooks() {
     
        Library library = new Library();

        Book book1 = new Book("Book1", "Author1", "1");
        Book book2 = new Book("Book2", "Author2", "2");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.listBooks();

        assertEquals(2, books.size());
    }

    @Test
    void testGetBookByAuthor() {

        Library library = new Library();

        Book book1 = new Book("Book1", "Author1", "1");
        Book book2 = new Book("Book2", "Author1", "2");
        Book book3 = new Book("Book3", "Author2", "3");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> result = library.getBooksByAuthor("Author1");

        assertEquals(2, result.size());
    }

    @Test
    void testEbookCreation() {
      
        Ebook ebook = new Ebook(
                "Clean Code",
                "Robert Martin",
                "10",
                5
        );

        assertNotNull(ebook);
        assertEquals("Clean Code", ebook.getTitle());
        assertEquals("Robert Martin", ebook.getAuthor());
        assertEquals("10", ebook.getIsbn());
        assertEquals(5, ebook.getFileSize());
    }

    @Test
    void testPaperBookCreation() {
       
        PaperBook paperBook = new PaperBook(
                "Design Patterns",
                "Gamma",
                "20",
                800
        );

        assertNotNull(paperBook);
        assertEquals("Design Patterns", paperBook.getTitle());
        assertEquals("Gamma", paperBook.getAuthor());
        assertEquals("20", paperBook.getIsbn());
        assertEquals(800, paperBook.getWeight());
    }
    
}
