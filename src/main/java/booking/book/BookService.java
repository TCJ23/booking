package booking.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tzje on 12/03/2018.
 */
public class BookService {
    private List<Book> bookList = Collections.synchronizedList(new ArrayList<Book>());

    public Book addBook(Book book) {
        bookList.add(book);
        return book;
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < bookList.size(); i++) {
            Book b = bookList.get(i);
            if (b.getIsbn().equals(isbn)) {
                bookList.remove(i);
                break;
            }
        }
    }

    public List<Book> findAll() {
        return new ArrayList<Book>(bookList);
    }

    public List<Book> findByISBN(String... isbns) {
        List<Book> bList = new ArrayList<>();
        List<String> isbnList = Arrays.asList(isbns);
        for (int i = 0; i < bookList.size(); i++) {
            Book b = bookList.get(i);
            if (isbnList.contains(b.getIsbn())) {
                bList.add(b);
            }
        }
        return bList;
    }
}
