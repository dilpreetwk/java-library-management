package org.example.java.libraray.management.registry;

import org.example.java.libraray.management.service.BookService;
import org.example.java.libraray.management.service.BorrowService;
import org.example.java.libraray.management.service.UserService;

public class ServiceRegistry {

    private static final BookService bookService = new BookService();
    private static final UserService userService = new UserService();
    private static final BorrowService borrowService = new BorrowService();

    public static BookService bookService() {
        return bookService;
    }

    public static UserService userService() {
        return userService;
    }

    public static BorrowService borrowService() {
        return borrowService;
    }
}
