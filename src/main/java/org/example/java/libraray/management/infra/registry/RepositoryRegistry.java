package org.example.java.libraray.management.infra.registry;

import org.example.java.libraray.management.infra.repository.BookRepository;
import org.example.java.libraray.management.infra.repository.UserRepository;

public class RepositoryRegistry {

    private static final BookRepository bookRepository = new BookRepository();
    private static final UserRepository userRepository = new UserRepository();

    public static BookRepository bookRepository() {
        return bookRepository;
    }

    public static UserRepository userRepository() {
        return userRepository;
    }
}
