package org.example.java.libraray.management.service;

import org.example.java.libraray.management.dto.BorrowOperationDTO;
import org.example.java.libraray.management.model.Book;
import org.example.java.libraray.management.model.Borrow;
import org.example.java.libraray.management.model.Policy;
import org.example.java.libraray.management.model.User;
import org.example.java.libraray.management.registry.RepositoryRegistry;
import org.example.java.libraray.management.repository.BookRepository;
import org.example.java.libraray.management.repository.BorrowRepository;
import org.example.java.libraray.management.repository.UserRepository;
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

        Borrow borrow = new Borrow();
        borrow.setId(borrowOperationDTO.getId());
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
