package org.example.java.libraray.management;

import org.example.java.libraray.management.registry.ServiceRegistry;
import org.example.java.libraray.management.util.LibraryCLIUtil;

import java.util.Scanner;

public class LibraryCLI {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            LibraryCLIUtil.printOperations();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> ServiceRegistry.bookService().addBook();
                case "2" -> ServiceRegistry.bookService().updateBook();
                case "3" -> ServiceRegistry.bookService().listBooks();
                case "4" -> ServiceRegistry.bookService().searchBooks();
                case "5" -> ServiceRegistry.userService().addUser();
                case "6" -> ServiceRegistry.userService().listUsers();
                case "7" -> {
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
