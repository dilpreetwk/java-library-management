package org.example.java.libraray.management.service;

import org.example.java.libraray.management.model.Book;
import org.example.java.libraray.management.registry.RepositoryRegistry;
import org.example.java.libraray.management.repository.BookRepository;
import org.example.java.libraray.management.util.BookUtil;

import java.util.Scanner;

public class BookService {

    private final BookRepository bookRepository = RepositoryRegistry.bookRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void addBook() {
        Book book = BookUtil.inputBookAddDetails();
        bookRepository.add(book);
        System.out.println("✅ Book added successfully!");
    }

    public void updateBook() {
        System.out.print("Enter book ID to update: ");
        Long bookId = scanner.nextLong();
        scanner.nextLine();

        Book existingBook = bookRepository.findById(bookId);
        Book updatedBook = BookUtil.inputBookUpdateDetails(existingBook);

        bookRepository.update(updatedBook);
        System.out.println("✅ Book updated successfully!");
    }

    public void listBooks() {
        bookRepository.findAll().forEach(System.out::println);
    }

    public void searchBooks() {
        System.out.print("Search books: ");
        String search = scanner.nextLine().trim();
        bookRepository.search(search).forEach(System.out::println);
    }
}
