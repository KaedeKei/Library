import java.util.Set;
import java.util.HashSet;

public class Library {
    private Set<Book> books;

    public Library() {
        books = new HashSet<>();
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public void listBooks() {
        for(Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByIsbn(String isbn) {
        for(Book book : books) {
            if(book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void findBooksByAuthor(String author) {
        boolean found = false;
        for(Book book : books) {
            if(book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Нет книг по данному автору");
        }
    }

    public void findBooksByGenre(String genre) {
        boolean found = false;
        for(Book book : books) {
            if(book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(book);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Нет книг по данному жанру");
        }
    }
}
