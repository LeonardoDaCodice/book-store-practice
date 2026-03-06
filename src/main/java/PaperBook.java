/**
 * Represents a physical paper book.
 */
public class PaperBook extends Book {

    private int weight;

    public PaperBook(String title, String author, String isbn, int weight) {
        super(title, author, isbn);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}