import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("Майстер і Маргарита", "Михайло Булгаков", "978-5-389-03879-5", 1967);
        library.addBook("1984", "Джордж Оруелл", "978-0-452-28423-4", 1949);
        library.addBook("Пісня льоду та полум'я: Гра престолів", "Джордж Р. Р. Мартін", "978-0-553-57340-4", 1996);

        library.showAllBooks();

        Book book = library.findBookByTitle("Майстер і Маргарита");
        if (book != null) {
            System.out.println("Знайдено книгу: " + book.getTitle());
        } else {
            System.out.println("Книгу не знайдено.");
        }

        library.deleteBookByIsbn("978-5-389-03879-5");
        library.showAllBooks();
    }
}