package org.example.java.libraray.management.repository;

import org.example.java.libraray.management.model.Borrow;

import java.util.HashMap;
import java.util.Map;

public class BorrowRepository {

    private final Map<Long, Borrow> borrowMap = new HashMap<>();

    public void borrow(Borrow borrow) {
        borrowMap.put(borrow.getId(), borrow);
    }
}
