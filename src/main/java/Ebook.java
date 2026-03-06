/**
 * Represents an Ebook in the library.
 */
public class Ebook extends Book {

    private int fileSize;

    public Ebook(String title, String author, String isbn, int fileSize) {
        super(title, author, isbn);
        this.fileSize = fileSize;
    }

    public int getFileSize() {
        return fileSize;
    }
}