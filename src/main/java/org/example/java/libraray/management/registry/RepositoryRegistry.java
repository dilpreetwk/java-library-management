package org.example.java.libraray.management.registry;

import org.example.java.libraray.management.repository.BookRepository;

public class RepositoryRegistry {

    private static final BookRepository bookRepository = new BookRepository();

    public static BookRepository bookRepository() {
        return bookRepository;
    }
}
