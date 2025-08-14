package org.example.java.libraray.management.app;

import org.example.java.libraray.management.core.exception.GlobalException;
import org.example.java.libraray.management.infra.registry.ServiceRegistry;
import org.example.java.libraray.management.util.LibraryCLIUtil;

import java.util.Scanner;

public class LibraryCLI {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            LibraryCLIUtil.printOperations();
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> ServiceRegistry.bookService().addBook();
                    case "2" -> ServiceRegistry.bookService().updateBook();
                    case "3" -> ServiceRegistry.bookService().listBooks();
                    case "4" -> ServiceRegistry.bookService().searchBooks();
                    case "5" -> ServiceRegistry.userService().addUser();
                    case "6" -> ServiceRegistry.userService().listUsers();
                    case "7" -> ServiceRegistry.borrowService().borrowBook();
                    case "8" -> ServiceRegistry.borrowService().returnBook();
                    case "9" -> ServiceRegistry.borrowService().listBorrowedBooks();
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
