package org.example.java.libraray.management.app;

import org.example.java.libraray.management.core.service.BookService;
import org.example.java.libraray.management.core.service.UserService;
import org.example.java.libraray.management.infra.repository.BookRepository;
import org.example.java.libraray.management.infra.repository.UserRepository;

import java.util.Scanner;

public class ApplicationConfig {

    private final Scanner scanner = new Scanner(System.in);

    private final BookRepository bookRepository = new BookRepository();
    private final UserRepository userRepository = new UserRepository();

    private final BookService bookService = new BookService(bookRepository, userRepository, scanner);
    private final UserService userService = new UserService(userRepository);

    public BookService bookService() {
        return bookService;
    }

    public UserService userService() {
        return userService;
    }
}
