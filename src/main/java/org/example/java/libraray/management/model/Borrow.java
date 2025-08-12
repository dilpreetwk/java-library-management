package org.example.java.libraray.management.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Borrow {

    private Long id;
    private Book book;
    private User user;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    @Override
    public String toString() {
        return String.format(
                "📚 Borrow ID: %d%n" +
                        "Book: %s%n" +
                        "User: %s%n" +
                        "Borrow Date: %s%n" +
                        "Return Date: %s%n",
                id,
                book != null ? book.getTitle() : "N/A",
                user != null ? user.getName() : "N/A",
                borrowDate != null ? borrowDate.toString() : "N/A",
                returnDate != null ? returnDate.toString() : "N/A"
        );
    }
}
