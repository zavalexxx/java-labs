import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        library.addBook("Майстер і Маргарита", "Михайло Булгаков", "978-5-389-03879-5", 1967);
        library.addBook("1984", "Джордж Оруелл", "978-0-452-28423-4", 1949);
        library.addBook("Пісня льоду та полум'я: Гра престолів", "Джордж Р. Р. Мартін", "978-0-553-57340-4", 1996);
    }

    @Test
    public void testAddBook() {
        library.addBook("Тестова книга", "Тестовий автор", "1234567890", 2023);
        assertNotNull(library.findBookByTitle("Тестова книга"));
    }

    @Test
    public void testFindBookByTitle() {
        Book book = library.findBookByTitle("Майстер і Маргарита");
        assertNotNull(book);
        assertEquals("Михайло Булгаков", book.getAuthor());
    }

    @Test
    public void testFindBookByTitleNotFound() {
        Book book = library.findBookByTitle("Неіснуюча книга");
        assertNull(book);
    }

    @Test
    public void testDeleteBookByIsbn() {
        library.deleteBookByIsbn("978-0-452-28423-4");
        assertNull(library.findBookByTitle("1984"));
    }

    @Test
    public void testDeleteBookByIsbnNotFound() {
        library.deleteBookByIsbn("1234567890");
        assertNotNull(library.findBookByTitle("1984"));
    }
}
