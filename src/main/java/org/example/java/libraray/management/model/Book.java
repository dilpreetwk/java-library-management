package org.example.java.libraray.management.model;

import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Book {

    private Long id;
    private String title;
    private Author author;
    private Set<Genre> genres;

    @Override
    public String toString() {
        return String.format(
                "📘 Book ID: %d%n" +
                        "Title: %s%n" +
                        "%s" +
                        "%s",
                id,
                title,
                author.toString(),
                genres.stream()
                        .map(Genre::toString)
                        .collect(Collectors.joining())
        );
    }
}
