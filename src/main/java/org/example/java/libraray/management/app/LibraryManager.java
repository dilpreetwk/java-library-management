package org.example.java.libraray.management.app;

import org.example.java.libraray.management.core.exception.GlobalException;
import org.example.java.libraray.management.util.LibraryCLIUtil;

import java.util.Scanner;

public class LibraryManager {
    private final Scanner scanner = new Scanner(System.in);
    private final ApplicationConfig appConfig = new ApplicationConfig();

    public void start() {
        while (true) {
            LibraryCLIUtil.printOperations();
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> appConfig.bookService().addBook();
                    case "2" -> appConfig.bookService().updateBook();
                    case "3" -> appConfig.bookService().listBooks();
                    case "4" -> appConfig.bookService().searchBooks();
                    case "5" -> appConfig.userService().addUser();
                    case "6" -> appConfig.userService().listUsers();
                    case "7" -> appConfig.bookService().borrowBook();
                    case "8" -> appConfig.bookService().returnBook();
                    case "9" -> appConfig.bookService().listBorrowedBooks();
                    case "10" -> {
                        System.out.println("Exiting the application. Goodbye!");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (GlobalException e) {
                System.out.println("⚠️ " + e.getMessage());
            }
        }
    }
}
