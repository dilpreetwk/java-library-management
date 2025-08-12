package org.example.java.libraray.management.registry;

import org.example.java.libraray.management.service.BookService;

public class ServiceRegistry {

    private static final BookService bookService = new BookService();

    public static BookService bookService() {
        return bookService;
    }
}
