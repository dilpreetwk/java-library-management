package org.example.java.libraray.management.repository;

import org.example.java.libraray.management.exception.GlobalException;
import org.example.java.libraray.management.model.Book;
import org.example.java.libraray.management.util.BookUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {

    private final Map<Long, Book> bookMap = new HashMap<>();

    public BookRepository() {
        bookMap.putAll(BookUtil.defaultSeedBookMap());
    }

    public Book findById(Long id) {
        if (!bookMap.containsKey(id)) {
            throw new GlobalException("Book not found with id: " + id);
        }

        return bookMap.get(id);
    }

    public List<Book> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    public Book add(Book book) {
        if (book.getId() == null) {
            throw new GlobalException("Book ID cannot be null");
        }

        bookMap.put(book.getId(), book);
        return book;
    }

    public void update(Book book) {
        if (book.getId() == null || !bookMap.containsKey(book.getId())) {
            throw new GlobalException("Book not found with id: " + book.getId());
        }

        bookMap.put(book.getId(), book);
    }

    public Book delete(Long id) {
        if (!bookMap.containsKey(id)) {
            throw new GlobalException("Book not found with id: " + id);
        }

        return bookMap.remove(id);
    }

    public List<Book> search(String search) {
        if (search == null || search.trim().isEmpty()) {
            return findAll();
        }

        String searchLower = search.toLowerCase();

        return bookMap.values().stream()
                .filter(book ->
                        book.getTitle().toLowerCase().contains(searchLower) ||
                                book.getAuthor().toLowerCase().contains(searchLower))
                .toList();
    }
}
