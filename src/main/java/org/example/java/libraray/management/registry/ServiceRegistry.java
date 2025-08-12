package org.example.java.libraray.management.registry;

import org.example.java.libraray.management.service.BookService;
import org.example.java.libraray.management.service.UserService;

public class ServiceRegistry {

    private static final BookService bookService = new BookService();
    private static final UserService userService = new UserService();

    public static BookService bookService() {
        return bookService;
    }

    public static UserService userService() {
        return userService;
    }
}
