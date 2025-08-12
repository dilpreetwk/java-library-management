package org.example.java.libraray.management.util;

import org.example.java.libraray.management.model.Author;
import org.example.java.libraray.management.model.Book;
import org.example.java.libraray.management.model.Genre;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BookUtil {

    public static Map<Long, Book> defaultSeedBookMap() {

        Map<Long, Book> books = new HashMap<>();

        // Get seeded authors & genres
        Map<Long, Author> authors = AuthorUtil.defaultSeedAuthorMap();
        Map<Long, Genre> genres = GenreUtil.defaultSeedGenreMap();

        Book b1 = new Book();
        b1.setId(1L);
        b1.setTitle("Harry Potter and the Sorcerer's Stone");
        b1.setAuthor(authors.get(1L));
        b1.setGenres(Set.of(genres.get(1L), genres.get(5L))); // Fantasy, Adventure

        Book b2 = new Book();
        b2.setId(2L);
        b2.setTitle("A Game of Thrones");
        b2.setAuthor(authors.get(2L));
        b2.setGenres(Set.of(genres.get(1L), genres.get(5L))); // Fantasy, Adventure

        Book b3 = new Book();
        b3.setId(3L);
        b3.setTitle("Murder on the Orient Express");
        b3.setAuthor(authors.get(3L));
        b3.setGenres(Set.of(genres.get(2L))); // Mystery

        Book b4 = new Book();
        b4.setId(4L);
        b4.setTitle("The Shining");
        b4.setAuthor(authors.get(5L));
        b4.setGenres(Set.of(genres.get(3L))); // Horror

        Book b5 = new Book();
        b5.setId(5L);
        b5.setTitle("The Hobbit");
        b5.setAuthor(authors.get(4L));
        b5.setGenres(Set.of(genres.get(1L), genres.get(5L))); // Fantasy, Adventure

        books.put(b1.getId(), b1);
        books.put(b2.getId(), b2);
        books.put(b3.getId(), b3);
        books.put(b4.getId(), b4);
        books.put(b5.getId(), b5);

        return books;
    }
}
