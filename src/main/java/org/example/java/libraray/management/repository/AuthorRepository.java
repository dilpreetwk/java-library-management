package org.example.java.libraray.management.repository;

import org.example.java.libraray.management.model.Author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class AuthorRepository {

    private final Map<Long, Author> authorMap = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Author findById(Long id) {
        if (!authorMap.containsKey(id)) {
            throw new RuntimeException("Author not found with id: " + id);
        }

        return authorMap.get(id);
    }

    public List<Author> findAll() {
        return new ArrayList<>(authorMap.values());
    }

    public Author create(Author author) {
        if (author.getId() == null) {
            author.setId(idGenerator.getAndIncrement());
        }

        authorMap.put(author.getId(), author);
        return author;
    }

    public Author update(Author author) {
        if (author.getId() == null || !authorMap.containsKey(author.getId())) {
            throw new RuntimeException("Author not found with id: " + author.getId());
        }

        authorMap.put(author.getId(), author);
        return author;
    }

    public Author delete(Long id) {
        if (!authorMap.containsKey(id)) {
            throw new RuntimeException("Author not found with id: " + id);
        }

        return authorMap.remove(id);
    }

    public List<Author> search(String search) {
        if (search == null || search.trim().isEmpty()) {
            return findAll();
        }

        String searchLower = search.toLowerCase();

        return authorMap.values().stream()
                .filter(author ->
                        author.getName().toLowerCase().contains(searchLower))
                .toList();
    }
}
