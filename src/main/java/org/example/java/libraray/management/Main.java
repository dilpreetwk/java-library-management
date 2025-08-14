package org.example.java.libraray.management;

import org.example.java.libraray.management.app.LibraryManager;

public class Main {

    public static void main(String[] args) {
        LibraryManager libraryCLI = new LibraryManager();
        libraryCLI.start();
    }
}