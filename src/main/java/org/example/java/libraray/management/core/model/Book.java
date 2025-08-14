package org.example.java.libraray.management.core.model;

import lombok.Data;

@Data
public class Book {

    private Long id;
    private String title;
    private String author;
    private String genres;

    @Override
    public String toString() {
        return String.format(
                "📘 Book ID: %d%n" +
                        "Title: %s%n" +
                        "Author: %s%n" +
                        "Genres: %s%n",
                id,
                title,
                author,
                genres
        );
    }
}
