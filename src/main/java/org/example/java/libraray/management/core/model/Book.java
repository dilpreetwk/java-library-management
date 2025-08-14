package org.example.java.libraray.management.core.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Book {

    private Long id;
    private String title;
    private String author;
    private String genres;

    // borrow relation
    private User borrowedBy;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format(
                "📘 Book ID: %d%n" +
                        "Title: %s%n" +
                        "Author: %s%n" +
                        "Genres: %s%n",
                id,
                title,
                author,
                genres
        ));

        if (borrowedBy != null) {
            sb.append(String.format(
                    "Borrowed By: %s%n" +
                            "Borrow Date: %s%n" +
                            "Due Date: %s%n",
                    borrowedBy.getName(),
                    borrowDate,
                    dueDate
            ));
        } else {
            sb.append("Status: ✅ Available\n");
        }
        return sb.toString();
    }
}
