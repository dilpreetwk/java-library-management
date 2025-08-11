package org.example.java.libraray.management.repository;

import org.example.java.libraray.management.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class BookRepository {

    private final Map<Long, Book> bookMap = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Book findById(Long id) {
        if (!bookMap.containsKey(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }

        return bookMap.get(id);
    }

    public List<Book> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    public Book create(Book book) {
        if (book.getId() == null) {
            book.setId(idGenerator.getAndIncrement());
        }

        bookMap.put(book.getId(), book);
        return book;
    }

    public Book update(Book book) {
        if (book.getId() == null || !bookMap.containsKey(book.getId())) {
            throw new RuntimeException("Book not found with id: " + book.getId());
        }

        bookMap.put(book.getId(), book);
        return book;
    }

    public Book delete(Long id) {
        if (!bookMap.containsKey(id)) {
            throw new RuntimeException("Book not found with id: " + id);
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
                                book.getAuthor().getName().toLowerCase().contains(searchLower))
                .toList();
    }
}
