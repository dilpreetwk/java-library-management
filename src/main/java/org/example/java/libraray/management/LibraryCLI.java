package org.example.java.libraray.management;

import org.example.java.libraray.management.util.LibraryCLIUtil;

import java.util.Scanner;

public class LibraryCLI {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            LibraryCLIUtil.printOperations();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> handleEntityMenu("Add");
                case "2" -> handleEntityMenu("Update");
                case "3" -> handleEntityMenu("List");
                case "4" -> handleEntityMenu("Get");
                case "5" -> handleEntityMenu("Delete");
                case "6" -> handleEntityMenu("Search");
                case "7" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void handleEntityMenu(String operation) {
        LibraryCLIUtil.printOperationOnEntity(operation);
        String entityChoice = scanner.nextLine();

        switch (entityChoice) {
            case "1" -> runAuthorCommand(operation);
            case "2" -> runBookCommand(operation);
            case "3" -> runGenreCommand(operation);
            default -> System.out.println("Invalid entity choice.");
        }
    }

    private void runAuthorCommand(String op) {
        switch (op) {
            default -> System.out.println("Operation not implemented yet for Author.");
        }
    }

    private void runBookCommand(String op) {
        switch (op) {
            default -> System.out.println("Operation not implemented yet for Book.");
        }
    }

    private void runGenreCommand(String op) {
        switch (op) {
            default -> System.out.println("Operation not implemented yet for Genre.");
        }
    }
}
