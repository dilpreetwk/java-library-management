package org.example.java.libraray.management.repository;

import org.example.java.libraray.management.core.exception.GlobalException;
import org.example.java.libraray.management.core.model.Borrow;
import org.example.java.libraray.management.infra.repository.BorrowRepository;
import org.example.java.libraray.management.util.BookUtil;
import org.example.java.libraray.management.util.UserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BorrowRepositoryTest {

    private BorrowRepository borrowRepository;
    private final Long borrowsSeeded = 3L;

    @BeforeEach
    void setUp() {
        borrowRepository = new BorrowRepository();
    }

    @Test
    void borrowBook_ShouldBorrowBook() {
        Borrow borrow = sampleBorrow();
        Borrow borrowedBook = borrowRepository.borrowBook(borrow);

        assertNotNull(borrowedBook);
        assertEquals(borrowsSeeded + 1L, borrowedBook.getId());
        assertEquals(1L, borrowedBook.getUser().getId());
        assertEquals(1L, borrowedBook.getBook().getId());
    }

    @Test
    void returnBook_RecordPresent_ShouldReturnBook() {
        Borrow borrow = sampleBorrow();
        Borrow borrowedBook = borrowRepository.borrowBook(borrow);

        Borrow returnedBook = borrowRepository.returnBook(borrowedBook.getId());

        assertNotNull(returnedBook);
        assertEquals(borrowedBook.getId(), returnedBook.getId());
    }

    @Test
    void returnBook_RecordNotPresent_ShouldThrowException() {
        GlobalException ex = assertThrows(GlobalException.class, () -> borrowRepository.returnBook(999L));
        assertEquals("Borrow record not found with id: 999", ex.getMessage());
    }

    @Test
    void findAll_ShouldReturnSeededBorrows() {
        assertEquals(borrowsSeeded, borrowRepository.findAll().size());
    }

    @Test
    void countUserBorrowedBooks_ShouldReturnCorrectCount() {
        Long userId = 1L;
        int count = borrowRepository.countUserBorrowedBooks(userId);

        assertEquals(1, count);
    }

    @Test
    void isBookBorrowed_ShouldReturnTrueIfBookIsBorrowed() {
        Long bookId = 1L;
        boolean isBorrowed = borrowRepository.isBookBorrowed(bookId);

        assertTrue(isBorrowed);
    }

    @Test
    void isBookBorrowed_ShouldReturnFalseIfBookIsNotBorrowed() {
        Long bookId = 999L;
        boolean isBorrowed = borrowRepository.isBookBorrowed(bookId);

        assertFalse(isBorrowed);
    }

    private Borrow sampleBorrow() {
        Borrow borrow = new Borrow();
        borrow.setUser(UserUtil.defaultSeedUserMap().get(1L));
        borrow.setBook(BookUtil.defaultSeedBookMap().get(1L));
        borrow.setBorrowDate(LocalDate.now());
        borrow.setReturnDate(LocalDate.now().plusDays(5));
        return borrow;
    }
}
