import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    private Patron patron;
    private Item book;
    private Item dvd;

    @Before
    public void setUp() {
        library = new Library();
        patron = new Patron("John Doe", "12345");
        book = new Book("The Great Gatsby", "B001", "F. Scott Fitzgerald");
        dvd = new DVD("Inception", "D001", 148);
    }

    @Test
    public void testRegisterPatron() {
        library.registerPatron(patron);
        assertTrue(library.getPatrons().contains(patron));
    }

    @Test
    public void testLendAndReturnItem() {
        library.registerPatron(patron);
        library.add(book);
        library.lendItem(patron, book);
        assertTrue(patron.getBorrowedItems().contains(book));
        assertTrue(book.isBorrowed());

        library.returnItem(patron, book);
        assertFalse(patron.getBorrowedItems().contains(book));
        assertFalse(book.isBorrowed());
    }

    @Test
    public void testListAvailableItems() {
        library.add(book);
        library.add(dvd);
        assertEquals(2, library.listAvailable().size());
    }

    @Test
    public void testListBorrowedItems() {
        library.registerPatron(patron);
        library.add(book);
        library.lendItem(patron, book);
        assertEquals(1, library.listBorrowed().size());
    }
}