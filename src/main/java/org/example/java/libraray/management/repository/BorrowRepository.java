package org.example.java.libraray.management.repository;

import org.example.java.libraray.management.exception.GlobalException;
import org.example.java.libraray.management.model.Borrow;
import org.example.java.libraray.management.util.BorrowUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BorrowRepository {

    private final Map<Long, Borrow> borrowMap = new HashMap<>();

    public BorrowRepository() {
        borrowMap.putAll(BorrowUtil.defaultSeedBorrowMap());
    }

    public Borrow borrowBook(Borrow borrow) {
        return borrowMap.put(borrow.getId(), borrow);
    }

    public Borrow returnBook(Long id) {
        if (!borrowMap.containsKey(id)) {
            throw new GlobalException("Borrow record not found with id: " + id);
        }

        return borrowMap.remove(id);
    }

    public List<Borrow> findAll() {
        return new ArrayList<>(borrowMap.values());
    }

    public Integer countUserBorrowedBooks(Long userId) {
        return (int) borrowMap.values().stream()
                .filter(borrow -> borrow.getUser().getId().equals(userId))
                .count();
    }

    public Boolean isBookBorrowed(Long bookId) {
        return borrowMap.values().stream()
                .anyMatch(borrow -> borrow.getBook().getId().equals(bookId));
    }
}
