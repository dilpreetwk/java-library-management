package org.example.java.libraray.management.core.service;

import org.example.java.libraray.management.core.dto.BorrowOperationDTO;
import org.example.java.libraray.management.core.exception.GlobalException;
import org.example.java.libraray.management.core.model.Book;
import org.example.java.libraray.management.core.model.Borrow;
import org.example.java.libraray.management.core.model.Policy;
import org.example.java.libraray.management.core.model.User;
import org.example.java.libraray.management.infra.registry.RepositoryRegistry;
import org.example.java.libraray.management.infra.repository.BookRepository;
import org.example.java.libraray.management.infra.repository.BorrowRepository;
import org.example.java.libraray.management.infra.repository.UserRepository;
import org.example.java.libraray.management.util.BorrowUtil;

import java.time.LocalDate;
import java.util.Scanner;

public class BorrowService {

    private final BorrowRepository borrowRepository = RepositoryRegistry.borrowRepository();
    private final BookRepository bookRepository = RepositoryRegistry.bookRepository();
    private final UserRepository userRepository = RepositoryRegistry.userRepository();
    private final Policy policy = new Policy();
    private final Scanner scanner = new Scanner(System.in);

    public void borrowBook() {
        BorrowOperationDTO borrowOperationDTO = BorrowUtil.inputBorrowOperationData();

        Book book = bookRepository.findById(borrowOperationDTO.getBookId());
        User user = userRepository.findById(borrowOperationDTO.getUserId());

        // check if user has reached borrow limit
        if (borrowRepository.countUserBorrowedBooks(user.getId()) >= policy.getBorrowLimit()) {
            throw new GlobalException("User has reached the maximum borrow limit!");
        }

        // check if book is already borrowed
        if (borrowRepository.isBookBorrowed(book.getId())) {
            throw new GlobalException("Book is already borrowed by another user!");
        }

        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setUser(user);
        borrow.setBorrowDate(LocalDate.now());
        borrow.setReturnDate(LocalDate.now().plusDays(policy.getBorrowDays()));

        borrowRepository.borrowBook(borrow);
        System.out.println("✅ Book borrowed successfully!");
    }

    public void returnBook() {
        System.out.print("Enter Borrow Id to return: ");
        Long borrowId = scanner.nextLong();
        scanner.nextLine();

        Borrow borrow = borrowRepository.returnBook(borrowId);
        System.out.println("✅ Book returned successfully!");
    }

    public void listBorrowedBooks() {
        borrowRepository.findAll().forEach(System.out::println);
    }
}
