import java.util.ArrayList;

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author, String isbn, int year) {
        Book newBook = new Book(title, author, isbn, year);
        books.add(newBook);
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Бібліотека порожня.");
        } else {
            System.out.println("Книги в бібліотеці:");
            for (Book book : books) {
                System.out.println("Назва: " + book.getTitle());
                System.out.println("Автор: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Рік видання: " + book.getYear());
                System.out.println("--------------------");
            }
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Книга не знайдена
    }

    public void deleteBookByIsbn(String isbn) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Книгу з ISBN " + isbn + " видалено з бібліотеки.");
        } else {
            System.out.println("Книгу з ISBN " + isbn + " не знайдено в бібліотеці.");
        }
    }
}