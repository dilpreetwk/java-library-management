package org.example.java.libraray.management.core.repository;

import org.example.java.libraray.management.core.model.Book;

import java.util.List;

public interface BookRepository {
    Book findById(Long id);

    List<Book> findAll();

    Book add(Book book);

    Book update(Book book);

    Book delete(Long id);

    List<Book> search(String search);
}
