package org.example.java.libraray.management.util;

import org.example.java.libraray.management.dto.BorrowOperationDTO;
import org.example.java.libraray.management.model.Book;
import org.example.java.libraray.management.model.Borrow;
import org.example.java.libraray.management.model.Policy;
import org.example.java.libraray.management.model.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BorrowUtil {

    private static final Scanner scanner = new Scanner(System.in);
    private final Policy policy = new Policy();

    public static Map<Long, Borrow> defaultSeedBorrowMap() {
        Map<Long, Borrow> borrows = new HashMap<>();

        Map<Long, Book> books = BookUtil.defaultSeedBookMap();
        Map<Long, User> users = UserUtil.defaultSeedUserMap();
        Policy policy = new Policy();

        Borrow br1 = new Borrow();
        br1.setId(1L);
        br1.setBook(books.get(1L)); // Harry Potter
        br1.setUser(users.get(1L)); // Alice Johnson
        br1.setBorrowDate(LocalDate.now());
        br1.setReturnDate(LocalDate.now().plusDays(policy.getBorrowDays()));

        Borrow br2 = new Borrow();
        br2.setId(2L);
        br2.setBook(books.get(3L)); // Murder on the Orient Express
        br2.setUser(users.get(2L)); // Bob Smith
        br2.setBorrowDate(LocalDate.now());
        br2.setReturnDate(LocalDate.now().plusDays(policy.getBorrowDays()));

        Borrow br3 = new Borrow();
        br3.setId(3L);
        br3.setBook(books.get(5L)); // The Hobbit
        br3.setUser(users.get(3L)); // Charlie Davis
        br3.setBorrowDate(LocalDate.now());
        br3.setReturnDate(LocalDate.now().plusDays(policy.getBorrowDays()));

        borrows.put(br1.getId(), br1);
        borrows.put(br2.getId(), br2);
        borrows.put(br3.getId(), br3);

        return borrows;
    }

    public static BorrowOperationDTO inputBorrowOperationData() {
        BorrowOperationDTO dto = new BorrowOperationDTO();

        System.out.print("Enter Book Id: ");
        dto.setBookId(Long.parseLong(scanner.nextLine().trim()));

        System.out.print("Enter User ID: ");
        dto.setUserId(Long.parseLong(scanner.nextLine().trim()));

        return dto;
    }
}
