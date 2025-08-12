package org.example.java.libraray.management.util;

public class LibraryCLIUtil {

    public static void printOperations() {
        System.out.println("\n===== 📚 Library Management CLI =====");
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. List");
        System.out.println("4. Get");
        System.out.println("5. Delete");
        System.out.println("6. Search");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    public static void printOperationOnEntity(String operation) {
        System.out.println("\n===== 📚 Library Management CLI =====");
        System.out.println("Operation: " + operation);
        System.out.println("1. Author");
        System.out.println("2. Book");
        System.out.println("3. Genre");
        System.out.print("Choose an entity: ");
    }
}
