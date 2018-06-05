package booking.book;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by tzje on 12/03/2018.
 */
public class BookServiceTest {

    @Test
    public void testAddNewBook() {
        //given
        Book testBook = new Book("Book1", "GRRM", "ISBN1", 2017);
        BookService bookService = new BookService();
        //when
        Book b = bookService.addBook(testBook);
        //then
        Assert.assertTrue(b != null);
        Assert.assertEquals(testBook, b);
    }
    @Test
    public void testFindAllBooks() {
        //given
        Book testBook = new Book("Book1", "GRRM", "ISBN1", 2017);
        Book testBook2 = new Book("Book2", "GRRM", "ISBN2", 2018);
        BookService bookService = new BookService();
        bookService.addBook(testBook);
        bookService.addBook(testBook2);
        //when
        List<Book> b = bookService.findAll();
        //then
        Assert.assertEquals(2,b.size());
        Assert.assertEquals(testBook,b.get(0));
        Assert.assertEquals(testBook2,b.get(1));
    }
    @Test
    public void testRemoveBook(){
        //given
        Book testBook = new Book("Book1", "GRRM", "ISBN1", 2017);
        Book testBook2 = new Book("Book2", "GRRM", "ISBN2", 2018);
        BookService bookService = new BookService();
        bookService.addBook(testBook);
        bookService.addBook(testBook2);
        //when
        bookService.removeBook(testBook.getIsbn());
        //then
        List<Book> r = bookService.findAll();
        Assert.assertEquals(1,r.size());
        Assert.assertEquals(testBook2,r.get(0));

    }
   /* @Test
    public void testfindByISBN(){
        //given
        Book testBook = new Book("Book1", "GRRM", "ISBN1", 2017);
        Book testBook2 = new Book("Book2", "GRRM", "ISBN2", 2018);
        BookService bookService = new BookService();
        bookService.addBook(testBook);
        bookService.addBook(testBook2);
        //when
        Book b = bookService.findByISBN(testBook.getIsbn());
        //then
        Assert.assertEquals(testBook,b);
        Assert.assertEquals(testBook.getIsbn(),b.getIsbn());
    }*/
}