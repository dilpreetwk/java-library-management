package org.example.java.libraray.management.registry;

import org.example.java.libraray.management.repository.AuthorRepository;
import org.example.java.libraray.management.repository.BookRepository;
import org.example.java.libraray.management.repository.GenreRepository;

public class RepositoryRegistry {

    private static final AuthorRepository authorRepository = new AuthorRepository();
    private static final BookRepository bookRepository = new BookRepository();
    private static final GenreRepository genreRepository = new GenreRepository();

    public static AuthorRepository authorRepository() {
        return authorRepository;
    }

    public static BookRepository bookRepository() {
        return bookRepository;
    }

    public static GenreRepository genreRepository() {
        return genreRepository;
    }
}
