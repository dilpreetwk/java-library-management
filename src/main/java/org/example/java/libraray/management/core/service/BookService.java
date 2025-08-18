package org.example.java.libraray.management.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.java.libraray.management.core.exception.GlobalException;
import org.example.java.libraray.management.core.model.Book;
import org.example.java.libraray.management.core.model.User;
import org.example.java.libraray.management.core.repository.BookRepository;
import org.example.java.libraray.management.core.repository.UserRepository;
import org.example.java.libraray.management.util.BookUtil;

import java.time.LocalDate;
import java.util.Scanner;

@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final Scanner scanner;

    public void addBook() {
        Book book = BookUtil.inputBookAddDetails();
        bookRepository.add(book);
        log.info("✅ Book added successfully");
    }

    public void updateBook() {
        System.out.print("Enter book ID to update: ");
        Long bookId = scanner.nextLong();
        scanner.nextLine();

        Book existingBook = bookRepository.findById(bookId);
        Book updatedBook = BookUtil.inputBookUpdateDetails(existingBook);

        bookRepository.update(updatedBook);
        log.info("✅ Book updated successfully!");
    }

    public void listBooks() {
        bookRepository.findAll().forEach(System.out::println);
    }

    public void searchBooks() {
        System.out.print("Search books: ");
        String search = scanner.nextLine().trim();
        bookRepository.search(search).forEach(System.out::println);
    }

    public void borrowBook() {
        System.out.print("Enter book ID to borrow: ");
        Long bookId = scanner.nextLong();
        scanner.nextLine();
        Book book = bookRepository.findById(bookId);

        // check if book is available
        if (book.getBorrowedBy() != null) {
            throw new GlobalException("Book is already borrowed");
        }

        System.out.print("Enter user ID that will borrow: ");
        Long userId = scanner.nextLong();
        scanner.nextLine();
        User user = userRepository.findById(userId);

        book.setBorrowedBy(user);
        book.setBorrowDate(LocalDate.now());
        book.setDueDate(LocalDate.now().plusDays(5));

        log.info("✅ Book borrowed successfully by {}", user.getName());
    }

    public void returnBook() {
        System.out.print("Enter book ID to return: ");
        Long bookId = scanner.nextLong();
        scanner.nextLine();
        Book book = bookRepository.findById(bookId);

        // check if book is borrowed
        if (book.getBorrowedBy() == null) {
            throw new GlobalException("Book is not borrowed");
        }

        book.setBorrowedBy(null);
        book.setBorrowDate(null);
        book.setDueDate(null);

        log.info("✅ Book returned successfully!");
    }

    public void listBorrowedBooks() {
        bookRepository.findAll().stream()
                .filter(book -> book.getBorrowedBy() != null)
                .forEach(System.out::println);
    }
}
