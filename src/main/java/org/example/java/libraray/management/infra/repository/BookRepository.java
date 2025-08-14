package org.example.java.libraray.management.infra.repository;

import org.example.java.libraray.management.core.exception.GlobalException;
import org.example.java.libraray.management.core.model.Book;
import org.example.java.libraray.management.util.BookUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class BookRepository {

    private final Map<Long, Book> bookMap = new HashMap<>();
    private final AtomicLong idGenerator;

    public BookRepository() {
        bookMap.putAll(BookUtil.defaultSeedBookMap());
        idGenerator = new AtomicLong(bookMap.size() + 1);
    }

    public Book findById(Long id) {
        return Optional.ofNullable(bookMap.get(id))
                .orElseThrow(() -> new GlobalException("Book not found with id: " + id));
    }

    public List<Book> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    public Book add(Book book) {
        book.setId(idGenerator.getAndIncrement());
        bookMap.put(book.getId(), book);
        return book;
    }

    public Book update(Book book) {
        if (book.getId() == null || !bookMap.containsKey(book.getId())) {
            throw new GlobalException("Book not found with id: " + book.getId());
        }

        return bookMap.put(book.getId(), book);
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
