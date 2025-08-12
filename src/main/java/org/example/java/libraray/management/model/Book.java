package org.example.java.libraray.management.model;

import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

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
