package booking.user;

import booking.Exception.LibraryException;
import booking.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private final String username;
    private final String firstname;
    private final String lastname;
    private final String email;
    private List<Book> userBookList;

    User(String username, String firstname, String lastname, String email) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(firstname);
        Objects.requireNonNull(lastname);
        Objects.requireNonNull(email);
        userBookList = new ArrayList<>();
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public void rentBook(Book book){
        if (!book.isRented()) {
            book.setRented(true);
            userBookList.add(book);
        }
        else {
            throw new LibraryException("Hi this book is already rented, would you like to rent another book?");
        }
    }
    public void returnBook(Book book){
        if (userBookList.remove(book)){
            book.setRented(false);
        }
    }
    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }
}
