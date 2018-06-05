package booking;

import booking.Exception.LibraryException;
import booking.book.Book;
import booking.book.BookService;
import booking.user.User;
import booking.user.UserService;

import java.util.List;

/**
 * Created by tzje on 12/03/2018.
 */
public class Main {

    public static void main (String [] args){

        UserService userService = new UserService();
        User user1 = userService.createUser("1","Tomasz","Jurek","tzje@gft.com");
        User user2 = userService.createUser("2","Marcin","Dziarmaga","mida@gft.com");

        BookService bookService = new BookService();
        bookService.addBook(new Book("Book1", "GRRM", "ISBN1", 2017));
        bookService.addBook(new Book("Book2", "GRRM", "ISBN2", 2017));
        bookService.addBook(new Book("Book3", "GRRM", "ISBN3", 2017));
        bookService.addBook(new Book("Book4", "GRRM", "ISBN4", 2017));

        List<Book> books4rent = bookService.findByISBN("ISBN1","ISBN2","ISBN3");
        List<Book> allBook2Forcerent = bookService.findAll();

        for (Book singleBook : books4rent) {
            user1.rentBook(singleBook);
        }

        for (Book singlebook2 : allBook2Forcerent) {
            try {
                user2.rentBook(singlebook2);
            }catch (LibraryException e){
                System.out.println(e.getMessage());
            }
        }


    }
}